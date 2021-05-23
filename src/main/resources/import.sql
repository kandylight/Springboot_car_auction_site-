insert into SELLER (sellerId, sellerName, sellerAddress, email) values (SELLER_SEQ.nextval, 'Hounslow cars', '333 wellington road hounslow TW3 5HS', 'hounslowcars@gmail.com');
insert into SELLER (sellerId, sellerName, sellerAddress, email) values (SELLER_SEQ.nextval, 'Dream cars', '2 hanworth road hanworth TW2 3AB', 'info@dreamcars.com');
insert into SELLER (sellerId, sellerName, sellerAddress, email) values (SELLER_SEQ.nextval, 'Winsford Auto', '10 high street Winsford CW7 6BU', 'winsfordauto@outlook.com');

insert into CAR (carId, make, model, fuelType, transmission, colour, co2Emission, price, description, sellerId) values (CAR_SEQ.nextval, 'Tesla', 'Model-S', 'Electric', 'Automatic', 'Black', 0, 56000, 'delivery available', 2);
insert into CAR (carId, make, model, fuelType, transmission, colour, co2Emission, price, description, sellerId) values (CAR_SEQ.nextval, 'BMW', 'M3', 'Diesel', 'Manual', 'Blue', 120, 35000, '17inch alloy wheels', 3);
insert into CAR (carId, make, model, fuelType, transmission, colour, co2Emission, price, description, sellerId) values (CAR_SEQ.nextval, 'Audi', 'A4', 'Patrol', 'Manual', 'Red', 115, 20000, 'Custom body kit fitted', 3);


insert into BUYER (buyerId, buyerName, buyerAddress) values (BUYER_SEQ.nextval, 'Sam Buttler', '7 Dean Drive Winsford CW6 3BC');
insert into BUYER (buyerId, buyerName, buyerAddress) values (BUYER_SEQ.nextval, 'Ron DeMel', '24 Park Lane London W4 6DE');
insert into BUYER (buyerId, buyerName, buyerAddress) values (BUYER_SEQ.nextval, 'Peter Perera', '2A Tidworth road Salisbury SP4 8LF');

insert into BID (bidId, bidDate, amount) values (BID_SEQ.nextval, TO_DATE('2021/05/05', 'yyyy/mm/dd'), 56500);

insert into BID_BUYER (bid_bidId, buyer_buyerId) values (1,3);
insert into BID_CAR (bid_bidId, car_carId) values (1,2);

insert into USER (userId, username, password) values (USER_SEQ.nextval, 'admin', 'admin');