drop function if exists `getChildrenProductName`;|
create function `getChildrenProductName`(orgid varchar(50))
returns varchar(4000)
BEGIN
DECLARE `oTemp` VARCHAR(4000);
DECLARE `oTempChild` VARCHAR(4000);
DECLARE `oTempName` VARCHAR(4000);
DECLARE `oTempChildName` VARCHAR(4000);
DECLARE i int;
SET oTemp = CAST(orgid AS CHAR);
SET oTempChild = CAST(orgid AS CHAR);
set oTempName = '$';
set oTempChildName = '';
set i = 0;
WHILE oTempChild IS NOT NULL
DO
if i>0 then
set oTempName = concat(oTempName,",",oTempChildName);
end if;
SET oTemp = CONCAT(oTemp,',',oTempChild);
set i = i +1;
SELECT GROUP_CONCAT(p.product_name,p.partnum) into oTempChildName FROM product p
left join bom b on b.PartID = p.PartID
 WHERE FIND_IN_SET(b.ParentPartID,oTempChild) > 0;
SELECT GROUP_CONCAT(p.PartID) INTO oTempChild FROM product p
left join bom b on b.PartID = p.PartID
 WHERE FIND_IN_SET(b.ParentPartID,oTempChild) > 0;
END WHILE;
RETURN oTempName;
END;|