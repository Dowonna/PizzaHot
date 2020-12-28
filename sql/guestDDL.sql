DROP TABLE guest cascade constraint;

DROP SEQUENCE guest_id_seq;

CREATE SEQUENCE guest_id_seq;

CREATE TABLE reservation (
       reservationNum          	NUMBER(5) PRIMARY KEY,
       menuName               	VARCHAR2(20) NOT NULL,
       foodNum         	VARCHAR2(20) NOT NULL,
      	id                	NUMBER(5) NULL
);
