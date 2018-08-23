create table if not exists users(
	ID INTEGER PRIMARY KEY AUTOINCREMENT,
	NAME TXT NOT NULL,
	LASTNAME TXT NOT NULL,
	LOGIN TXT NOT NULL UNIQUE,
	PASSWORD INTEGER NOT NULL,
	EMAIL TXT NOT NULL UNIQUE,
	LOGGING TXT DEFAULT UNKNOWN,
	ALBUMS INTEGER DEFAULT 0
);	
