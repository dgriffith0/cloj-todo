CREATE TABLE todo (
   todo_id INTEGER PRIMARY KEY AUTOINCREMENT,
   description VARCHAR(255) NOT NULL,
   completed BOOL Default false,
   created_on DATE DEFAULT CURRENT_TIMESTAMP
);

