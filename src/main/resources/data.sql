
CREATE TABLE IF NOT EXISTS earnings(
    id int auto_increment primary key,
    date varchar(20),
    epsActual  varchar(20),
    epsEstimate varchar(20),
    hour varchar(20),
    quarter varchar(20),
    revenueActual varchar(20),
    revenueEstimate varchar(20),
    symbol varchar(20),
    year varchar(20)
);