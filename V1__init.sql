BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Entries" (
	"entryId"	INTEGER PRIMARY KEY AUTO_INCREMENT,
	"name"	TEXT NOT NULL,
	"color"	TEXT,
	"date"	DATE NOT NULL,
	"category"	TEXT,
	"description"	TEXT,
	"personId"	INTEGER NOT NULL,
	
);
CREATE TABLE IF NOT EXISTS "Person" (
	"userId"	INTEGER PRIMARY KEY AUTO_INCREMENT,
	"name"	TEXT NOT NULL,
	"password"	TEXT NOT NULL,
	"email"	TEXT UNIQUE,
	"picture"	BLOB,
	"description"	TEXT,
	"position"	INTEGER,
	"entriesId"	INTEGER NOT NULL,
	
);
CREATE TABLE IF NOT EXISTS "type" (
	"typeId"	INTEGER PRIMARY KEY AUTO_INCREMENT,
	"name"	TEXT NOT NULL,
	"description"	TEXT,
	"priority"	INTEGER NOT NULL,
	"entriesId"	INTEGER NOT NULL,
	
);
COMMIT;
