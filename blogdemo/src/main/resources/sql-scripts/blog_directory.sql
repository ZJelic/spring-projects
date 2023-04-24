CREATE DATABASE  IF NOT EXISTS `blog_directory`;
USE `blog_directory`;

--
-- Tables structures for tables 'users', 'blog_posts', 'comments'
--

CREATE TABLE users (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE blog_posts (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  content TEXT NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  user_id INT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE comments (
  id INT NOT NULL AUTO_INCREMENT,
  content TEXT NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  user_id INT NOT NULL,
  blogpost_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (blogpost_id) REFERENCES blog_posts(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for tables 'users', 'blog_posts', 'comments'
--

INSERT INTO users (id, username, password, email) VALUES 
		(1, 'eric', 'password123', 'eric@gmail.com'),
		(2, 'thomas', 'letmein', 'thomas@gmail.com'),
		(3, 'anna', 'abc123', 'anna@gmail.com');

INSERT INTO blog_posts (id, title, content, created_at, updated_at, user_id) VALUES
		(1, 'My first blog post', 'This is a great new blog!', '2022-04-20 10:00:00', '2022-04-20 11:30:00', 1),
		(2, 'Second post', 'This is even a better blog!', '2022-04-21 09:00:00', '2022-04-21 12:00:00', 2),
		(3, 'Third post', 'Content of this blog is amazing.', '2022-04-22 14:00:00', '2022-04-22 16:30:00', 1);

INSERT INTO comments (id, content, created_at, updated_at, user_id, blogpost_id) VALUES
		(1, 'I agree with you.', '2022-04-20 11:00:00', '2022-04-20 11:00:00', 2, 1),
        (2, 'I enjoyed reading this.', '2022-04-21 10:00:00', '2022-04-21 10:00:00', 1, 2),
        (3, 'Thanks for sharing!', '2022-04-22 15:00:00', '2022-04-22 15:00:00', 3, 3);