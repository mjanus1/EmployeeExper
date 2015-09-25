

CREATE TABLE Core_Wojewodzctwo
(
	id_woj int not null identity(1,1),
	nazwa varchar(15) not null
	Constraint PK_Core_Wojewodzctwo_id_woj primary key(id_woj) 
);

CREATE TABLE Core_Miasto
(
	id_miasto int not null identity(1,1),
	id_woj int not null,
	nazwa varchar(25) not null,
	kod_pocztowy char(6)
	Constraint PK_Core_Miasto_id_miasto primary key(id_miasto),
	Constraint FK_Core_Miasto_id_woj foreign key(id_woj) references Core_Wojewodzctwo(id_woj)
	
);

CREATE TABLE Core_Adres
(
	id_adres int not null identity(1,1),
	id_miasto int not null,
	ulica varchar(40) not null,
	nr_domu varchar(4) not null,
	nr_lokalu varchar(4) not null
	Constraint PK_Core_Adres_id_adres primary key(id_adres),
	Constraint FK_Core_Adres_id_miasto foreign key(id_miasto) references Core_Miasto(id_miasto)
);

CREATE TABLE Core_Stanowiska_Pracy
(
	id_stanowisko int not null identity(1,1),
	nazwa_stanowiska varchar(20) not null,
	opis_stanowiska varchar(500) not null
	Constraint PK_Core_Stanowiska_Pacy_id_stanowisko primary key(id_stanowisko)
);

CREATE TABLE Core_Typ_Umowy
(
	id_typ_umowy tinyint not null identity(1,1),
	rodzaj varchar(30) not null
	Constraint PK_Core_Typ_Umowy_id_typ_umowy primary key(id_typ_umowy)
);

CREATE TABLE Core_Stawki_Placowe
(
	rok smallint not null,
	id_typ_umowy tinyint not null,
	podatek_dochodowy int not null,
	skladka_chorobowa tinyint not null,
	skladka_ubezpieczenie tinyint not null
	Constraint PK_Core_Stawki_Placowe_rok_id_typ_umowy primary key(rok,id_typ_umowy),
	Constraint FK_Core_Stawki_Placowe_id_typ_umowy foreign key(id_typ_umowy) references Core_Typ_Umowy(id_typ_umowy)	
);

CREATE TABLE Core_Typ_Zwolnienia
(
	id_typ_zwolnienia tinyint not null identity(1,1),
	nazwa varchar(40) not null
	Constraint PK_Core_Typ_Zwolnienia_id_typ_zwolnienia primary key(id_typ_zwolnienia)
);

CREATE TABLE Core_Typ_Zwolnienia_Ustawienia
(
	rok smallint not null,
	id_typ_zwolnienia tinyint not null,
	liczba_dni_wolnych tinyint null,
	platnosc_procent tinyint not null
	Constraint PK_Core_Typ_Zwolnienia_Ustawienia_rok_id_typ_zwolnienia primary key(rok,id_typ_zwolnienia),
	Constraint FK_Core_Typ_Zolnienia_Ustawienia_id_typ_zwolnienia foreign key(id_typ_zwolnienia) references Core_Typ_Zwolnienia(id_typ_zwolnienia)
);

CREATE TABLE Core_Firma
(
	id_firma smallint not null identity(1,1),
	id_adres int not null,
	--id_dzial int not null        myśle że tego ma tu nie być chyba 
	nazwa varchar(40) not null
	Constraint PK_Core_Firma_id_firma primary key(id_firma),
	Constraint FK_Core_Firma_id_adres foreign key(id_adres) references Core_Adres(id_adres)
);


CREATE TABLE Core_Pracownik
(
	id_pracownik int not null identity(1,1),
	imie varchar(20) not null,
	nazwisko varchar(40) not null,
	data_urodzenia date not null,
	telefon_kom char(9) null,
	telefon_stac char(12) null,
	telefon_firmowy char(9) null,
	plec char(1) not null,
	pesel varchar(11) not null,
	mail varchar(256) null,
	mail_firmowy varchar(256) null,
	data_zatrudnienia date not null,
	data_zwolnienia date null,
	nip char(10) not null,
	
	id_oddzial int not null,
	id_przelozony int not null,
	id_adres_korespondencja int not null,
	id_adres_zamieszkania int not null
	Constraint PK_Core_Pracownik_id_pracownik primary key(id_pracownik),
	
	Constraint FK_Core_Pracownik_id_przelozony foreign key(id_przelozony) references Core_Pracownik(id_pracownik),
	Constraint FK_Core_Pracownik_id_adres_korespondencja foreign key(id_adres_korespondencja) references Core_Adres(id_adres),	
	Constraint FK_Core_Pracownik_id_adres_zamieszkania foreign key(id_adres_zamieszkania) references Core_Adres(id_adres)
);

CREATE TABLE Core_Oddzial
(
	id_oddzial int not null identity(1,1),
	id_oddzial_nadrzedny int null,     -- oddział może ale nie musi miec pododdziały 
	id_adres int not null,
	nazwa varchar(30) not null,
	id_ceo int not null,                   -- id_ceo nie mam pojecia dlaczego taka nazwa i jest to id.?
	id_firma smallint not null
	Constraint PK_Core_Oddzial_id_oddzial primary key(id_oddzial),
	Constraint FK_Core_Oddzial_id_oddzial_nadrzedny foreign key(id_oddzial_nadrzedny) references Core_Oddzial(id_oddzial),
	Constraint FK_Core_Oddzial_id_adres foreign key(id_adres) references Core_Adres(id_adres),
	Constraint FK_Core_Oddzial_id_ceo foreign key(id_ceo) references Core_Pracownik(id_pracownik),
	Constraint FK_Core_Oddzial_id_firma foreign key(id_firma) references Core_Firma(id_firma)
);

ALTER TABLE Core_Pracownik
add Constraint FK_Core_Pracownik_id_oodzial foreign key(id_oddzial) references Core_Oddzial(id_oddzial)

CREATE TABLE Core_Historia_Zatrudnienia
(
	id_historia int not null identity(1,1),
	zatrudniony_od datetime not null,
	zatrudniony_do datetime not null,
	nazwa_firmy varchar(40) not null,
	opis_stanowiska varchar(200) not null,
	id_pracownik int not null       -- dodałem referencje do tabeli Core_Pracownik
	Constraint PK_Core_Historia_Zatrudnienia_id_historia primary key(id_historia),
	Constraint FK_Core_Historia_Zatrudnienia_id_pracownik foreign key(id_pracownik) references Core_Pracownik(id_pracownik)
);

CREATE TABLE Core_Zwolnienie 
(
	id_zwolnienie int not null identity(1,1),
	data_od datetime not null,
	data_do datetime not null,
	opis varchar(500) not null,
	id_typ_zwolnienia tinyint not null,
	id_pracownik int not null     -- dodałem referencje do tabeli Core_Pracownik
	Constraint PK_Core_Zwolnienie_id_zwolnienie primary key(id_zwolnienie),
	Constraint FK_Core_Zwolnienie_id_typ_zwolnienia foreign key(id_typ_zwolnienia) references Core_Typ_Zwolnienia(id_typ_zwolnienia),
	Constraint FK_Core_Zwolnienie_id_pracownik foreign key(id_pracownik) references Core_Pracownik(id_pracownik)
);

CREATE TABLE Core_Zatrudnienie 
(
	id_zatrudnienie tinyint not null identity(1,1),
	umowa_od date not null,
	umowa_do date not null,
	pensja numeric(7,2) not null,
	liczba_dni_dziennie tinyint not null,
	wymiar numeric(3,2) not null,
	-- FK
	id_typ_umowy tinyint not null,
	id_stanowisko int not null,
	id_pracownik int not null
	Constraint PK_Core_Zatrudnienie_id_zatrudnienie primary key(id_zatrudnienie),
	Constraint FK_Core_Zatrudnienie_id_typ_umowy foreign key(id_typ_umowy) references Core_Typ_Umowy(id_typ_umowy),
	Constraint FK_Core_Zatrudnienie_id_stanowisko foreign key(id_stanowisko) references Core_Stanowiska_Pracy(id_stanowisko),
	Constraint FK_Core_Zatrudnienie_id_pracownik foreign key(id_pracownik) references Core_Pracownik(id_pracownik)
);

CREATE TABLE Auth_Uzytkownik
(
	login varchar(12) not null,
	haslo varchar(64) not null,
	licza_prob_logowania tinyint null,
	status bit not null,
	aktywne bit not null,
	waznosc_konta_od date not null,
	waznosc_konta_do date not null,
	id_pracownik int null
	Constraint PK_Auth_Uzytkownik_login primary key(login),
	Constraint FK_Auth_Uzytkownik_id_pracownik foreign key(id_pracownik) references Core_Pracownik(id_pracownik)	
);

CREATE TABLE Auth_Typ_Zdarzen
(
	id_typ_zdarzenia bigint not null identity(1,1),
	opis varchar(200) not null,
	Constraint PK_Auth_Typ_Zdarzen_id_typ_zdarzenia primary key(id_typ_zdarzenia) 
);

CREATE TABLE Auth_Zdarzenia
(
	id_zdarzenie bigint not null identity(1,1),
	data_zdarzenia datetime not null,
	parametry varchar(200) not null,
	--FK
	login varchar(12) not null,
	id_typ_zdarzenia bigint not null
	Constraint PK_Auth_Zdarzenia_id_zdarzenie primary key(id_zdarzenie),
	Constraint FK_Auth_Zdarzenia_login foreign key(login) references Auth_Uzytkownik(login),
	Constraint FK_Auth_Zdarzenia_id_typ_zdarzenia foreign key(id_typ_zdarzenia) references Auth_Typ_Zdarzen(id_typ_zdarzenia)
);

CREATE TABLE Auth_Rola
(
	kod_roli varchar(50) not null,
	nazwa_roli varchar(20) not null,
	opis varchar(200) not null
	Constraint PK_Auth_Rola_kod_roli primary key(kod_roli)
);

CREATE TABLE Auth_Uzytkownik_Rola
(
	login varchar(12) not null,
	kod_roli varchar(50) not null
	Constraint PK_Auth_Uzytkownik_Rola_login_kod_roli primary key(login, kod_roli),
	Constraint FK_Auth_Uzytkownik_Rola_login foreign key(login) references Auth_Uzytkownik(login),
	Constraint FK_Auth_Uzytkownik_Rola_kod_roli foreign key(kod_roli) references Auth_Rola(kod_roli)
);

CREATE TABLE Auth_Grupa
(
	id_grupa int not null identity(1,1),
	nazwa varchar(20) not null,
	opis varchar(150) not null
	Constraint PK_Auth_Grupa_id_grupa primary key(id_grupa)
);

CREATE TABLE Auth_Role_W_Grupie
(
	id_grupa int not null,
	kod_roli varchar(50) not null
	Constraint PK_Auth_Role_W_Grupie_id_grupa_kod_roli primary key(id_grupa, kod_roli),
	Constraint FK_Auth_Role_W_Grupie_id_grupa foreign key(id_grupa) references Auth_Grupa(id_grupa),
	Constraint FK_Auth_Role_W_Grupie_kod_roli foreign key(kod_roli) references Auth_Rola(kod_roli)
);

CREATE TABLE Auth_Uzytkownik_Grupa
(
	login varchar(12) not null,
	id_grupa int not null
	Constraint PK_Auth_Uzytkownik_Grupa_login_id_grupa primary key(login, id_grupa),
	Constraint FK_Auth_Uzytkownik_Grupa_login foreign key(login) references Auth_Uzytkownik(login),
	Constraint FK_Auth_Uzytkownik_Grupa_id_grupa foreign key(id_grupa) references Auth_Grupa(id_grupa) 
);

CREATE TABLE Dok_Typ_Dokumentu
(
	id_typ_dokumentu tinyint not null identity(1,1),
	nazwa varchar(30) not null
	Constraint PK_Dok_Typ_Dokumentu_id_typ_dokumentu primary key(id_typ_dokumentu)
);

CREATE TABLE Dok_Dokument
(
	id_dokument int not null identity(1,1),
	nazwa varchar(100) not null,
	data_ varbinary not null,
	data_dodania datetime not null,
	---FK
	id_typ_dokumentu tinyint not null,
	id_pracownik int not null,
	login varchar(12) not null
	Constraint PK_Dok_Dokument_id_dokument primary key(id_dokument),
	Constraint FK_Dok_Dokument_id_typ_dokumentu foreign key(id_typ_dokumentu) references Dok_Typ_Dokumentu(id_typ_dokumentu),
	Constraint FK_Dok_Dokument_id_pracownik foreign key(id_pracownik) references Core_Pracownik(id_pracownik),
	Constraint FK_Dok_Dokument_login foreign key(login) references Auth_Uzytkownik(login)
);




