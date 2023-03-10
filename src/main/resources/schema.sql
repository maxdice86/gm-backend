DROP TABLE IF EXISTS `billing`;
CREATE TABLE `billing` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dates` varchar(255) DEFAULT NULL,
  `clients` varchar(255) DEFAULT NULL,
  `project` varchar(255) DEFAULT NULL,
  `project_code` varchar(255) DEFAULT NULL,
  `hours` double DEFAULT NULL,
  `billable` varchar(5) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `bill_rate` int DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE VIEW billing_View AS
select
A.project as name ,
A.clients as clients ,
sum(A.hours) as hours,
nonbillable as billable_Hours,
sum(A.bill_rate * A.hours) as billable_Amount,
from BILLING A
join (select project , sum(hours) as nonbillable from  billing where billable = 'Yes' group by project) as B
on A.project = B.project
group by A.project;


CREATE VIEW NoBillable_View AS
select
A.project as name ,
A.clients as clients ,
sum(A.hours) as hours,
sum(A.hours) - nonbillable as billable_Hours,
sum(A.bill_rate * A.hours) as billable_Amount,
from BILLING A
join (select project , sum(hours) as nonbillable from  billing where billable = 'No' group by project) as B
on A.project = B.project
group by A.project;


CREATE VIEW All_View AS
select * from billing_View
union
select * from NoBillable_View;

drop view if exists revenue_View;
CREATE VIEW revenue_View AS
select
name,
clients,
hours,
billable_Hours,
billable_Amount
from ALL_VIEW;
