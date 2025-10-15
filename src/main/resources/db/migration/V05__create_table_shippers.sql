CREATE TABLE "Shippers" (
	"ShipperID" "int" IDENTITY (1, 1) NOT NULL ,
	"CompanyName" nvarchar (40) NOT NULL ,
	"Phone" nvarchar (24) NULL ,
	CONSTRAINT "PK_Shippers" PRIMARY KEY  CLUSTERED
	(
		"ShipperID"
	)
)
GO

SET quoted_identifier ON
GO

SET identity_insert "Shippers" ON
GO

ALTER TABLE "Shippers" NOCHECK CONSTRAINT ALL
GO

INSERT "Shippers"("ShipperID","CompanyName","Phone") VALUES(1,'Speedy Express','(503) 555-9831')
INSERT "Shippers"("ShipperID","CompanyName","Phone") VALUES(2,'United Package','(503) 555-3199')
INSERT "Shippers"("ShipperID","CompanyName","Phone") VALUES(3,'Federal Shipping','(503) 555-9931')
GO

SET identity_insert "Shippers" off
GO

ALTER TABLE "Shippers" CHECK CONSTRAINT ALL
GO