# DDL

This project contains the database script for initializing the PostgreSQL database of NCI Test

## Install
Download [Postgres 9.5] (https://www.postgresql.org/download/)<br/>

Deploy the database scripts<br/>
Open command line window and then:<br/>
<code>cd ddl</code><br/>
<code>psql --username=postgres -W -f create_nci_db.sql</code><br/>
<code>psql --username=postgres --dbname=ncicore -W -f create_nci_test_tables.sql</code><br/>
