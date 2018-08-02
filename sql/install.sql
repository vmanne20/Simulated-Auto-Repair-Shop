drop table if exists attends cascade;
drop table if exists scouttrip cascade;
drop table if exists scout cascade;

CREATE TABLE ScoutTrip
(
  Location VARCHAR(256) NOT NULL,
  TripDate DATE NOT NULL,
  MinAge INT,
  MinRank VARCHAR(16),
  PRIMARY KEY (TripDate)
);

CREATE TABLE Scout
(
  Name VARCHAR(64) NOT NULL,
  DOB DATE NOT NULL,
  Rank VARCHAR(16) NOT NULL,
  PRIMARY KEY (Name)
);

CREATE TABLE Attends
(
  TripDate DATE NOT NULL,
  Name VARCHAR(64) NOT NULL,
  PRIMARY KEY (TripDate, Name),
  FOREIGN KEY (TripDate) REFERENCES ScoutTrip(TripDate),
  FOREIGN KEY (Name) REFERENCES Scout(Name)
);

