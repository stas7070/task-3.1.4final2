INSERT INTO roles(role) VALUES ('ROLE_ADMIN'),
                               ('ROLE_USER');

INSERT INTO users(email, last_name, name, password) VALUES ('admin@email.com', 'Lastname1', 'name1', '$2a$10$7PbTPYcitT126BV6VfqSFuU890Z.5tlV6ZuGCyoVFjIv6IS5uguBG'),
                                                           ('user@email.com', 'Lastname2', 'name2', '$2a$12$r/0ut37helMnoM5Md0Xhv.PfzOAu7tezQ07oI//yKStsijkYhQnqG');

INSERT INTO user_roles VALUES (1, 1),
                              (2, 2);