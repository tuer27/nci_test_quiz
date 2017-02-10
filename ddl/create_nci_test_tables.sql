DROP SCHEMA IF EXISTS ncitest CASCADE;

CREATE SCHEMA ncitest
  AUTHORIZATION postgres;

GRANT ALL ON SCHEMA ncitest TO postgres;
GRANT ALL ON SCHEMA ncitest TO nciapp;

CREATE TABLE ncitest.topic_category
(
  id 			integer NOT NULL,
  name 			character varying(255) NOT NULL,
  description	text NOT NULL,
  create_ts		timestamp without time zone NOT NULL DEFAULT now(),
  CONSTRAINT nci_topic_category_pkey PRIMARY KEY (id)
);
ALTER TABLE ncitest.topic_category OWNER TO nciapp;
GRANT ALL ON ncitest.topic_category TO postgres;

insert into ncitest.topic_category (id, name, description) values (1, 'news', 'Latest news');
insert into ncitest.topic_category (id, name, description) values (2, 'jobs', 'Recruiting');
insert into ncitest.topic_category (id, name, description) values (3, 'bd', 'Business development');

CREATE TABLE ncitest.topic
(
  id 			serial NOT NULL,
  name 			character varying(1024) NOT NULL,
  category_id	integer,
  create_ts		timestamp without time zone NOT NULL DEFAULT now(),
  update_ts		timestamp without time zone NOT NULL,
  CONSTRAINT nci_topic_pkey PRIMARY KEY (id),
  CONSTRAINT nci_topic_category_fk FOREIGN KEY (category_id) REFERENCES ncitest.topic_category(id)
);
ALTER TABLE ncitest.topic OWNER TO nciapp;
GRANT ALL ON ncitest.topic TO postgres;

CREATE TABLE ncitest.message
(
  id 			serial NOT NULL,
  author 		character varying(255) NOT NULL,
  topic_id		integer,
  message		text,
  create_ts		timestamp without time zone NOT NULL DEFAULT now(),
  CONSTRAINT nci_message_pkey PRIMARY KEY (id),
  CONSTRAINT nci_message_topic_fk FOREIGN KEY (topic_id) REFERENCES ncitest.topic(id)
);
ALTER TABLE ncitest.message OWNER TO nciapp;
GRANT ALL ON ncitest.message TO postgres;
