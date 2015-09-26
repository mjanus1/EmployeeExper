alter table Core_Historia_Zatrudnienia
drop column zatrudniony_od 
GO
alter table Core_Historia_Zatrudnienia
drop column zatrudniony_do 
GO

alter table Core_Historia_Zatrudnienia
add zatrudniony_od date not null
GO
alter table Core_Historia_Zatrudnienia
add zatrudniony_do date not null
GO
