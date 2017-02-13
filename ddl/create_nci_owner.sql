
DROP TABLE IF EXISTS ncitest.owner;
CREATE TABLE ncitest.owner
(
  id 			serial NOT NULL,
  name 			character varying(1024) NOT NULL,
  topic_id	integer,
  create_ts		timestamp without time zone NOT NULL DEFAULT now(),
  update_ts		timestamp without time zone NOT NULL,
  CONSTRAINT nci_owner_pkey PRIMARY KEY (id),
  CONSTRAINT nci_topic_fk FOREIGN KEY (topic_id) REFERENCES ncitest.topic(id)
);
ALTER TABLE ncitest.owner OWNER TO nciapp;
GRANT ALL ON ncitest.owner TO postgres;