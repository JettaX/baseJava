create table resume
(
    uuid      char(36) not null
        constraint resume_pk
            primary key,
    full_name text     NOT NULL
);

create table contact
(
    id          serial,
    resume_uuid char(36) not null references resume (uuid) on delete cascade,
    type        text     not null,
    value       text     not null
);

create unique index contact_uuid_type_index
    on contact (resume_uuid, type);

CREATE TABLE section (
                         id          SERIAL PRIMARY KEY,
                         resume_uuid CHAR(36) NOT NULL REFERENCES resume (uuid) ON DELETE CASCADE,
                         type        TEXT     NOT NULL,
                         content     TEXT     NOT NULL
);
CREATE UNIQUE INDEX section_idx
    ON section (resume_uuid, type);