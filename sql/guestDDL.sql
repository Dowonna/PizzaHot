DROP TABLE guest cascade constraint;

DROP SEQUENCE guest_id_seq;

CREATE SEQUENCE guest_id_seq;

CREATE TABLE reservation (
       reservationNum          	NUMBER(5) PRIMARY KEY,
       menuName               	VARCHAR2(20) NOT NULL,
       foodNum         	VARCHAR2(20) NOT NULL,
      	id                	NUMBER(5) NULL
);

ALTER TABLE reservation  ADD FOREIGN KEY (menuName) REFERENCES menu (name);
ALTER TABLE reservation  ADD FOREIGN KEY (id) REFERENCES guest (guest_id);
