BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Entry" (
	"entryId"	INTEGER NOT NULL,
	"name"	TEXT NOT NULL,
	"color"	TEXT,
	"date"	DATE NOT NULL,
	"category"	TEXT,
	"description"	TEXT,
	"userId"	INTEGER NOT NULL,
	PRIMARY KEY("entryId"),
	FOREIGN KEY("userId") REFERENCES "User"("userId")
);
CREATE TABLE IF NOT EXISTS "User" (
	"userId"	INTEGER NOT NULL,
	"name"	TEXT NOT NULL,
	"password"	TEXT NOT NULL,
	"email"	TEXT UNIQUE,
	"picture"	BLOB,
	"description"	TEXT,
	"position"	INTEGER,
	"entryId"	INTEGER NOT NULL,
	PRIMARY KEY("userId"),
	FOREIGN KEY("entryId") REFERENCES "Entry"("entryId")
);
CREATE TABLE IF NOT EXISTS "type" (
	"typeId"	INTEGER NOT NULL,
	"name"	TEXT NOT NULL,
	"description"	TEXT,
	"priority"	INTEGER NOT NULL,
	"entryId"	INTEGER NOT NULL,
	PRIMARY KEY("typeId"),
	FOREIGN KEY("entryId") REFERENCES "Entry"("entryId")
);
COMMIT;
