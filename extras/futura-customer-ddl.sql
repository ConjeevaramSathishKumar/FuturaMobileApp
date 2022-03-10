/* Script starts from here*/
drop table if exists service_request;
drop table if exists policy_master;
drop table if exists  premium_frequency;
drop table  if exists service_request_status;
drop table  if exists policy_alteration;
drop table  if exists party;
drop table  if exists party_identification_type;
drop table  if exists address;
drop table if exists  state;
drop table  if exists country;
drop table  if exists party_type;
drop sequence  if exists policy_code_serial;
drop table  if exists confirmation_token;
drop table  if exists user_roles;
drop table  if exists roles;
drop table  if exists app_user;
drop table  if exists user_type;



--1. 
create table if not exists user_type(
id serial not null primary key,
user_type_desc varchar(100)
);

insert into user_type values(1,'Normal User');
insert into user_type values(2,'Admin User');
insert into user_type values(3,'Super User');
insert into user_type values(4,'External User');--This user is migrated user from other system
insert into user_type values(5,'In App User');

--2.
CREATE TABLE if not exists app_user (
	id bigserial not null primary key,
	created_date TIMESTAMP default current_timestamp NOT NULL,
    last_updated TIMESTAMP default current_timestamp NOT NULL,
	username VARCHAR ( 50 ) UNIQUE NOT NULL,
	password VARCHAR ( 100 ) NOT NULL,
	email VARCHAR ( 255 ) unique NOT null,
	first_name varchar(100),
	last_name varchar(100),
	user_source_type int8,
	is_valid boolean,
	validity_token varchar(100),
	locked boolean default false,
	CONSTRAINT fk_user_src_type FOREIGN KEY(user_source_type) REFERENCES user_type(id)
);

insert into app_user values(1,current_timestamp,current_timestamp,'narayan','narayan123','narayan_dhumale@yahoo.com','Narayan','Dhumale',5,true,'sdfjksdklf',false);

--3.
create table if not exists roles(
id serial not null primary key,
role_desc varchar(100)
);

insert into roles values(1,'APP_USER_READ_ONLY');
insert into roles values(2,'APP_USER_READ_EDIT_OWN_DATA');
insert into roles values(3,'APP_USER_READ_EDIT_ALL_DATA');

--4.
create table if not exists user_roles(
id bigserial not null primary key,
user_id int8,
role_id int8,
CONSTRAINT fk_urm_user_id FOREIGN KEY(user_id) REFERENCES app_user(id),
CONSTRAINT fk_urm_user_role FOREIGN KEY(role_id) REFERENCES roles(id)
);

insert into user_roles values(1,1,1);
insert into user_roles values(2,1,2);
insert into user_roles values(3,1,3);

--5.
create table if not exists party_type(
 id bigserial not null primary key,
 party_type_desc varchar(255)
);

insert into party_type values(1,'Policy Holder');
insert into party_type values(2,'Policy Life Assured');
insert into party_type values(3,'Policy Beneficery');
insert into party_type values(4,'Policy Assignee');
insert into party_type values(5,'Policy Servicing Agent');
insert into party_type values(6,'Policy Marketing Agent');

--6. 
create table if not exists country (
id bigserial not null primary key,
country_full_name varchar(150),
country_short_name varchar(50),
country_currency varchar(50),
country_currency_code char(5)
);

--insert into country values(1,'India','IND','Indian Rupees','INR');
INSERT INTO country(id,country_full_name,country_short_name,country_currency_code) VALUES 
(1,'Afghanistan','AF','AFG')
,(2,'Aland Islands','AX','ALA')
,(3,'Albania','AL','ALB')
,(4,'Algeria','DZ','DZA')
,(5,'American Samoa','AS','ASM')
,(6,'Andorra','AD','AND')
,(7,'Angola','AO','AGO')
,(8,'Anguilla','AI','AIA')
,(9,'Antarctica','AQ','ATA')
,(10,'Antigua and Barbuda','AG','ATG')
,(11,'Argentina','AR','ARG')
,(12,'Armenia','AM','ARM')
,(13,'Aruba','AW','ABW')
,(14,'Australia','AU','AUS')
,(15,'Austria','AT','AUT')
,(16,'Azerbaijan','AZ','AZE')
,(17,'Bahamas','BS','BHS')
,(18,'Bahrain','BH','BHR')
,(19,'Bangladesh','BD','BGD')
,(20,'Barbados','BB','BRB')
,(21,'Belarus','BY','BLR')
,(22,'Belgium','BE','BEL')
,(23,'Belize','BZ','BLZ')
,(24,'Benin','BJ','BEN')
,(25,'Bermuda','BM','BMU')
,(26,'Bhutan','BT','BTN')
,(27,'Bolivia','BO','BOL')
,(28,'Bonaire, Sint Eustatius and Saba','BQ','BES')
,(29,'Bosnia and Herzegovina','BA','BIH')
,(30,'Botswana','BW','BWA')
,(31,'Bouvet Island','BV','BVT')
,(32,'Brazil','BR','BRA')
,(33,'British Indian Ocean Territory','IO','IOT')
,(34,'Brunei','BN','BRN')
,(35,'Bulgaria','BG','BGR')
,(36,'Burkina Faso','BF','BFA')
,(37,'Burundi','BI','BDI')
,(38,'Cambodia','KH','KHM')
,(39,'Cameroon','CM','CMR')
,(40,'Canada','CA','CAN')
,(41,'Cape Verde','CV','CPV')
,(42,'Cayman Islands','KY','CYM')
,(43,'Central African Republic','CF','CAF')
,(44,'Chad','TD','TCD')
,(45,'Chile','CL','CHL')
,(46,'China','CN','CHN')
,(47,'Christmas Island','CX','CXR')
,(48,'Cocos (Keeling) Islands','CC','CCK')
,(49,'Colombia','CO','COL')
,(50,'Comoros','KM','COM')
,(51,'Congo','CG','COG')
,(52,'Cook Islands','CK','COK')
,(53,'Costa Rica','CR','CRI')
,(54,'Ivory Coast','CI','CIV')
,(55,'Croatia','HR','HRV')
,(56,'Cuba','CU','CUB')
,(57,'Curacao','CW','CUW')
,(58,'Cyprus','CY','CYP')
,(59,'Czech Republic','CZ','CZE')
,(60,'Democratic Republic of the Congo','CD','COD')
,(61,'Denmark','DK','DNK')
,(62,'Djibouti','DJ','DJI')
,(63,'Dominica','DM','DMA')
,(64,'Dominican Republic','DO','DOM')
,(65,'Ecuador','EC','ECU')
,(66,'Egypt','EG','EGY')
,(67,'El Salvador','SV','SLV')
,(68,'Equatorial Guinea','GQ','GNQ')
,(69,'Eritrea','ER','ERI')
,(70,'Estonia','EE','EST')
,(71,'Ethiopia','ET','ETH')
,(72,'Falkland Islands (Malvinas)','FK','FLK')
,(73,'Faroe Islands','FO','FRO')
,(74,'Fiji','FJ','FJI')
,(75,'Finland','FI','FIN')
,(76,'France','FR','FRA')
,(77,'French Guiana','GF','GUF')
,(78,'French Polynesia','PF','PYF')
,(79,'French Southern Territories','TF','ATF')
,(80,'Gabon','GA','GAB')
,(81,'Gambia','GM','GMB')
,(82,'Georgia','GE','GEO')
,(83,'Germany','DE','DEU')
,(84,'Ghana','GH','GHA')
,(85,'Gibraltar','GI','GIB')
,(86,'Greece','GR','GRC')
,(87,'Greenland','GL','GRL')
,(88,'Grenada','GD','GRD')
,(89,'Guadaloupe','GP','GLP')
,(90,'Guam','GU','GUM')
,(91,'Guatemala','GT','GTM')
,(92,'Guernsey','GG','GGY')
,(93,'Guinea','GN','GIN')
,(94,'Guinea-Bissau','GW','GNB')
,(95,'Guyana','GY','GUY')
,(96,'Haiti','HT','HTI')
,(97,'Heard Island and McDonald Islands','HM','HMD')
,(98,'Honduras','HN','HND')
,(99,'Hong Kong','HK','HKG')
,(100,'Hungary','HU','HUN')
,(101,'Iceland','IS','ISL')
,(102,'India','IN','IND')
,(103,'Indonesia','ID','IDN')
,(104,'Iran','IR','IRN')
,(105,'Iraq','IQ','IRQ')
,(106,'Ireland','IE','IRL')
,(107,'Isle of Man','IM','IMN')
,(108,'Israel','IL','ISR')
,(109,'Italy','IT','ITA')
,(110,'Jamaica','JM','JAM')
,(111,'Japan','JP','JPN')
,(112,'Jersey','JE','JEY')
,(113,'Jordan','JO','JOR')
,(114,'Kazakhstan','KZ','KAZ')
,(115,'Kenya','KE','KEN')
,(116,'Kiribati','KI','KIR')
,(117,'Kosovo','XK','---')
,(118,'Kuwait','KW','KWT')
,(119,'Kyrgyzstan','KG','KGZ')
,(120,'Laos','LA','LAO')
,(121,'Latvia','LV','LVA')
,(122,'Lebanon','LB','LBN')
,(123,'Lesotho','LS','LSO')
,(124,'Liberia','LR','LBR')
,(125,'Libya','LY','LBY')
,(126,'Liechtenstein','LI','LIE')
,(127,'Lithuania','LT','LTU')
,(128,'Luxembourg','LU','LUX')
,(129,'Macao','MO','MAC')
,(130,'Macedonia','MK','MKD')
,(131,'Madagascar','MG','MDG')
,(132,'Malawi','MW','MWI')
,(133,'Malaysia','MY','MYS')
,(134,'Maldives','MV','MDV')
,(135,'Mali','ML','MLI')
,(136,'Malta','MT','MLT')
,(137,'Marshall Islands','MH','MHL')
,(138,'Martinique','MQ','MTQ')
,(139,'Mauritania','MR','MRT')
,(140,'Mauritius','MU','MUS')
,(141,'Mayotte','YT','MYT')
,(143,'Micronesia','FM','FSM')
,(142,'Mexico','MX','MEX')
,(144,'Moldava','MD','MDA')
,(145,'Monaco','MC','MCO')
,(146,'Mongolia','MN','MNG')
,(147,'Montenegro','ME','MNE')
,(148,'Montserrat','MS','MSR')
,(149,'Morocco','MA','MAR')
,(150,'Mozambique','MZ','MOZ')
,(151,'Myanmar (Burma)','MM','MMR')
,(152,'Namibia','NA','NAM')
,(153,'Nauru','NR','NRU')
,(154,'Nepal','NP','NPL')
,(155,'Netherlands','NL','NLD')
,(156,'New Caledonia','NC','NCL')
,(157,'New Zealand','NZ','NZL')
,(158,'Nicaragua','NI','NIC')
,(159,'Niger','NE','NER')
,(160,'Nigeria','NG','NGA')
,(161,'Niue','NU','NIU')
,(162,'Norfolk Island','NF','NFK')
,(163,'North Korea','KP','PRK')
,(164,'Northern Mariana Islands','MP','MNP')
,(165,'Norway','NO','NOR')
,(166,'Oman','OM','OMN')
,(167,'Pakistan','PK','PAK')
,(168,'Palau','PW','PLW')
,(169,'Palestine','PS','PSE')
,(170,'Panama','PA','PAN')
,(171,'Papua New Guinea','PG','PNG')
,(172,'Paraguay','PY','PRY')
,(173,'Peru','PE','PER')
,(174,'Phillipines','PH','PHL')
,(175,'Pitcairn','PN','PCN')
,(176,'Poland','PL','POL')
,(177,'Portugal','PT','PRT')
,(178,'Puerto Rico','PR','PRI')
,(179,'Qatar','QA','QAT')
,(180,'Reunion','RE','REU')
,(181,'Romania','RO','ROU')
,(182,'Russia','RU','RUS')
,(183,'Rwanda','RW','RWA')
,(184,'Saint Barthelemy','BL','BLM')
,(185,'Saint Helena','SH','SHN')
,(186,'Saint Kitts and Nevis','KN','KNA')
,(187,'Saint Lucia','LC','LCA')
,(188,'Saint Martin','MF','MAF')
,(189,'Saint Pierre and Miquelon','PM','SPM')
,(190,'Saint Vincent and the Grenadines','VC','VCT')
,(191,'Samoa','WS','WSM')
,(192,'San Marino','SM','SMR')
,(193,'Sao Tome and Principe','ST','STP')
,(194,'Saudi Arabia','SA','SAU')
,(195,'Senegal','SN','SEN')
,(196,'Serbia','RS','SRB')
,(197,'Seychelles','SC','SYC')
,(198,'Sierra Leone','SL','SLE')
,(199,'Singapore','SG','SGP')
,(200,'Sint Maarten','SX','SXM')
,(201,'Slovakia','SK','SVK')
,(202,'Slovenia','SI','SVN')
,(203,'Solomon Islands','SB','SLB')
,(204,'Somalia','SO','SOM')
,(205,'South Africa','ZA','ZAF')
,(206,'South Georgia and the South Sandwich Islands','GS','SGS')
,(207,'South Korea','KR','KOR')
,(208,'South Sudan','SS','SSD')
,(209,'Spain','ES','ESP')
,(210,'Sri Lanka','LK','LKA')
,(211,'Sudan','SD','SDN')
,(212,'Suriname','SR','SUR')
,(213,'Svalbard and Jan Mayen','SJ','SJM')
,(214,'Swaziland','SZ','SWZ')
,(215,'Sweden','SE','SWE')
,(216,'Switzerland','CH','CHE')
,(217,'Syria','SY','SYR')
,(218,'Taiwan','TW','TWN')
,(219,'Tajikistan','TJ','TJK')
,(220,'Tanzania','TZ','TZA')
,(221,'Thailand','TH','THA')
,(222,'Timor-Leste (East Timor)','TL','TLS')
,(223,'Togo','TG','TGO')
,(224,'Tokelau','TK','TKL')
,(225,'Tonga','TO','TON')
,(226,'Trinidad and Tobago','TT','TTO')
,(227,'Tunisia','TN','TUN')
,(228,'Turkey','TR','TUR')
,(229,'Turkmenistan','TM','TKM')
,(230,'Turks and Caicos Islands','TC','TCA')
,(231,'Tuvalu','TV','TUV')
,(232,'Uganda','UG','UGA')
,(233,'Ukraine','UA','UKR')
,(234,'United Arab Emirates','AE','ARE')
,(235,'United Kingdom','GB','GBR')
,(236,'United States','US','USA')
,(237,'United States Minor Outlying Islands','UM','UMI')
,(238,'Uruguay','UY','URY')
,(239,'Uzbekistan','UZ','UZB')
,(240,'Vanuatu','VU','VUT')
,(241,'Vatican City','VA','VAT')
,(242,'Venezuela','VE','VEN')
,(243,'Vietnam','VN','VNM')
,(244,'Virgin Islands, British','VG','VGB')
,(245,'Virgin Islands, US','VI','VIR')
,(246,'Wallis and Futuna','WF','WLF')
,(247,'Western Sahara','EH','ESH')
,(248,'Yemen','YE','YEM')
,(249,'Zambia','ZM','ZMB')
,(250,'Zimbabwe','ZW','ZWE');

update country set country_currency_code = null;


--8.
create table if not exists state (
id serial not null primary key,
state_name varchar(150)
);

INSERT INTO state (id,state_name) VALUES
(1, 'ANDAMAN AND NICOBAR ISLANDS'),
(2, 'ANDHRA PRADESH'),
(3, 'ARUNACHAL PRADESH'),
(4, 'ASSAM'),
(5, 'BIHAR'),
(6, 'CHATTISGARH'),
(7, 'CHANDIGARH'),
(8, 'DAMAN AND DIU'),
(9, 'DELHI'),
(10, 'DADRA AND NAGAR HAVELI'),
(11, 'GOA'),
(12, 'GUJARAT'),
(13, 'HIMACHAL PRADESH'),
(14, 'HARYANA'),
(15, 'JAMMU AND KASHMIR'),
(16, 'JHARKHAND'),
(17, 'KERALA'),
(18, 'KARNATAKA'),
(19, 'LAKSHADWEEP'),
(20, 'MEGHALAYA'),
(21, 'MAHARASHTRA'),
(22, 'MANIPUR'),
(23, 'MADHYA PRADESH'),
(24, 'MIZORAM'),
(25, 'NAGALAND'),
(26, 'ORISSA'),
(27, 'PUNJAB'),
(28, 'PONDICHERRY'),
(29, 'RAJASTHAN'),
(30, 'SIKKIM'),
(31, 'TAMIL NADU'),
(32, 'TRIPURA'),
(33, 'UTTARAKHAND'),
(34, 'UTTAR PRADESH'),
(35, 'WEST BENGAL'),
(36, 'TELANGANA');

--9.
create table if not exists address (
id bigserial not null primary key,
created_date TIMESTAMP default current_timestamp NOT NULL,
last_updated TIMESTAMP default current_timestamp NOT NULL,
address_type varchar(50),--PARMANENT_ADDRESS,CORRESPONDENCE_ADDRESS,OFFICE_ADDRESS,RESIDENTIAL_ADDRESS
address_line_1 varchar(200),
address_line_2 varchar(200),
address_line_3 varchar(200),
address_line_4 varchar(200),
address_line_5 varchar(200),
is_active_address boolean,
city varchar(100),
pincode varchar(100),
state int8,
country int8,
CONSTRAINT fk_addr_state FOREIGN KEY(state) REFERENCES state(id),
CONSTRAINT fk_addr_country FOREIGN KEY(country) REFERENCES country(id)
);

insert into address values(1,current_timestamp,current_timestamp,'PARMANENT_ADDRESS','#F902','F-Block','9th Floor Alpine Eco Apartment,','Doddanekkundi','Marathahalli',true,'Bangalore','560037',1,1);
select * from address;

--10.
create table if not exists party_identification_type(
id serial not null primary key,
party_id_type varchar(150)
);

insert into party_identification_type values(1,'Aadhaar Card');
insert into party_identification_type values(2,'PAN Card');
insert into party_identification_type values(3,'Driving License');
insert into party_identification_type values(4,'Passport');
insert into party_identification_type values(5,'Election Commission ID Card');

--11.
create table if not exists party (
 id bigserial not null primary key,
 created_date TIMESTAMP default current_timestamp NOT NULL,
 last_updated TIMESTAMP default current_timestamp NOT NULL,
 party_type int8,
 first_name varchar(100),
 middle_name varchar(100),
 last_name varchar(100),
 birth_date date,
 father_name varchar(100),
 party_id_type int8,
 id_issue_date date,
 id_expire_date date,
 email varchar(150),
 mobile varchar(12),
 CONSTRAINT fk_party_type FOREIGN KEY(party_type) REFERENCES party_type(id),
 CONSTRAINT fk_party_id_type FOREIGN KEY(party_id_type) REFERENCES party_identification_type(id)
);

--ph
insert into party values(1,current_timestamp,current_timestamp, 1,'Narayan','','Dhumale',to_date('09-09-1976','dd-mm-yyyy'),'Ramrao Dhumale',1,to_date('01-12-2008','dd-mm-yyyy'),to_date('01-12-2028','dd-mm-yyyy'),'narayan_dhumale@yahoo.com','7899136681');
--life assured
insert into party values(2,current_timestamp,current_timestamp,2,'Narayan','','Dhumale',to_date('09-09-1976','dd-mm-yyyy'),'Ramrao Dhumale',1,to_date('01-12-2008','dd-mm-yyyy'),to_date('01-12-2028','dd-mm-yyyy'),'narayan_dhumale@yahoo.com','7899136681');
--beneficery/nominee
insert into party values(3,current_timestamp,current_timestamp,3,'Sarika','','Dhumale',to_date('26-12-1984','dd-mm-yyyy'),'Narayan Dhumale',1,to_date('01-12-2008','dd-mm-yyyy'),to_date('01-12-2028','dd-mm-yyyy'),'sarikasuryan@yahoo.co.in','9663052928');
--servicing agent
insert into party values(4,current_timestamp,current_timestamp,5,'Service','','Agent',to_date('26-12-1984','dd-mm-yyyy'),'Narayan Dhumale',1,to_date('01-12-2008','dd-mm-yyyy'),to_date('01-12-2028','dd-mm-yyyy'),'sarikasuryan@yahoo.co.in','9663052928');
--marketing agent
insert into party values(5,current_timestamp,current_timestamp,6,'Marketing','','Agent',to_date('26-12-1984','dd-mm-yyyy'),'Narayan Dhumale',1,to_date('01-12-2008','dd-mm-yyyy'),to_date('01-12-2028','dd-mm-yyyy'),'sarikasuryan@yahoo.co.in','9663052928');



--12.
create table if not exists policy_alteration(
id bigserial primary key not null,
alteration_name varchar(150)
);

insert into policy_alteration(alteration_name) values('Change Address');
insert into policy_alteration(alteration_name) values('Fund Switch');
insert into policy_alteration(alteration_name) values('Change Premium Payment Frequency');
insert into policy_alteration(alteration_name) values('Change Bank Account');
insert into policy_alteration(alteration_name) values('Get Loan Quote');
insert into policy_alteration(alteration_name) values('Increase Sum Assured');
insert into policy_alteration(alteration_name) values('Decrease Sum Assured');
insert into policy_alteration(alteration_name) values('Premium Top-Up');
insert into policy_alteration(alteration_name) values('Get Surrender Quote');

--select * from policy_alteration;


--13.
create table if not exists service_request_status(
id serial not null primary key,
service_status_name varchar(150)
);

insert into service_request_status values(1,'Draft');
insert into service_request_status values(2,'Submitted');
insert into service_request_status values(3,'In-Progress');
insert into service_request_status values(4,'Referred Back');
insert into service_request_status values(5,'Completed');

--14.
create table if not exists premium_frequency(
id serial not null primary key,
frequency_term varchar(100) not null,
renewal_freq_monthly int8);

insert into premium_frequency values(1,'Yearly',12);
insert into premium_frequency values(2,'Half-Yearly',6);
insert into premium_frequency values(3,'Quarterly',3);
insert into premium_frequency values(4,'Monthly',1);
insert into premium_frequency values(5,'One Time',1);

--15
CREATE SEQUENCE if not exists policy_code_serial START 1000;

--16.
create table if not exists policy_master(
 id bigserial not null primary key,
 policy_id int8,
 policy_code text NOT NULL DEFAULT 'PO' || nextval('policy_code_serial'),
 created_date timestamp,
 last_update timestamp,
 created_by_id int8 null,
 last_updated_by_id int8 null,
 start_date date,
 risk_end_date date,
 premium_due_date date,
 premium_end_date date,
 ph_id int8,
 ph_address_id int8,
 servicing_agent_id int8,
 marketing_agent_id int8,
 premium_frequency int8,
 CONSTRAINT fk_cm_created_by FOREIGN KEY(created_by_id) REFERENCES app_user(id),
 CONSTRAINT fk_cm_updated_by FOREIGN KEY(last_updated_by_id) REFERENCES app_user(id),
 CONSTRAINT fk_cm_ph_id FOREIGN KEY(ph_id) REFERENCES party(id),
 CONSTRAINT fk_cm_addr_id FOREIGN KEY(ph_address_id) REFERENCES address(id),
 CONSTRAINT fk_cm_sagent_id FOREIGN KEY(servicing_agent_id) REFERENCES party(id),
 CONSTRAINT fk_cm_magent_id FOREIGN KEY(marketing_agent_id) REFERENCES party(id),
 CONSTRAINT fk_cm_prem_freq FOREIGN KEY(premium_frequency) REFERENCES premium_frequency(id)
 );

insert into policy_master(created_date,last_update,start_date,risk_end_date,premium_due_date,premium_end_date,ph_id,ph_address_id,servicing_agent_id,marketing_agent_id,premium_frequency)
values(current_timestamp,current_timestamp,to_date('01-01-2021','dd-mm-yyyy'),to_date('01-12-2022','dd-mm-yyyy'),to_date('01-11-2021','dd-mm-yyyy'),to_date('01-11-2021','dd-mm-yyyy')
,1,1,4,5,1);

--17.
create table if not exists service_request(
id bigserial not null primary key,
created_date timestamp,
last_update timestamp,
created_by_id int8,
last_updated_by_id int8,
policy_id int8,
alteration_id int8,
remarks varchar(255),
sr_eff_start_date timestamp,
sr_eff_end_date timestamp,
sr_status int8,
CONSTRAINT fk_sr_created_by FOREIGN KEY(created_by_id) REFERENCES app_user(id),
CONSTRAINT fk_sr_updated_by FOREIGN KEY(last_updated_by_id) REFERENCES app_user(id),
CONSTRAINT fk_sr_pl_alt FOREIGN KEY(sr_status) REFERENCES policy_alteration(id),
CONSTRAINT fk_sr_policy_id FOREIGN KEY(policy_id) REFERENCES policy_master(id),
CONSTRAINT fk_sr_status FOREIGN KEY(sr_status) REFERENCES service_request_status(id)
);

insert into service_request(created_date,last_update,policy_id,alteration_id,remarks,sr_eff_start_date,sr_eff_end_date,sr_status)
values(current_timestamp,current_timestamp,1,1,'Test Remarks',current_timestamp,current_timestamp,1);