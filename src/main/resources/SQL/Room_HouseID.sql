
DECLARE @houseCount INT,
	@count INT,
	@roomCount INT;

SET @count = 1;


select @roomCount = count(1) from Room;
select @houseCount = count(1) from house;

WHILE @count <= @roomCount BEGIN

	UPDATE Room SET HouseID = CONVERT(INT,RAND() * @houseCount) WHERe id = @count;
	SET @count = @count + 1;

	print(@Count)
END

 

