CREATE TABLE IF NOT EXISTS WALLETS(
	ID INTEGER PRIMARY KEY AUTOINCREMENT,
	BALANCE INTEGER NOT NULL,
	USER_ID INTEGER NOT NULL,
	FOREIGN KEY(USER_ID) REFERENCES USERS(ID) ON DELETE CASCADE
);	
