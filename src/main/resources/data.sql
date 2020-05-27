INSERT INTO CLIENT (client_id, name, description)
VALUES (1, 'client 1' , 'great client'),
(2, 'client 2', 'also a great client'),
(3, 'client 3', 'best client');

INSERT INTO INVESTOR (investor_id, client_id, name, description)
VALUES (1, 1, 'investor 1' , 'High performing investor'),
(2, 1, 'investor 2', 'Savvy investor'),
(3, 3, 'investor 3', 'Wise investor');

INSERT INTO FUND (fund_id, investor_id, name, description)
VALUES (1, 1, 'fund 1' , 'High performing fund'),
(2, 1, 'fund 2', 'Low performing fund'),
(3, 3, 'fund 3', 'Average fund');