-- *********************************************************************
-- Update Database Script
-- *********************************************************************
-- Change Log: liquibase/master.xml
-- Ran at: 1/3/20 5:13 PM
-- Against: null@offline:mssql
-- Liquibase version: 3.8.7
-- *********************************************************************

-- Changeset liquibase/release-v1/create-user-table.xml::20200301-001::ajits01
CREATE TABLE APP_USER_TBL (id bigint IDENTITY (1, 1) NOT NULL, username varchar(255) NOT NULL, password varchar(255), salt varchar(255), phone varchar(255), email varchar(255), CONSTRAINT PK_APP_USER_TBL PRIMARY KEY (id))
GO

-- Changeset liquibase/release-v1/insert-into-user-table.xml::20200301-002::ajits01
INSERT INTO APP_USER_TBL (username, password, salt, phone, email) VALUES ('johndoe', 'johnpass', 'xakSD!T3asdg#aNl', '1234567890', 'johndoe@domain')
GO

INSERT INTO APP_USER_TBL (username, password, salt, phone, email) VALUES ('janedoe', 'janepass', NULL, '1123456789', 'janedoe@domain')
GO

