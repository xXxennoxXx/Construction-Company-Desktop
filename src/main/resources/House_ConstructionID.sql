
DECLARE @houseCount INT,
	@count INT,
	@constructionCount INT;

SET @count = 1;


select @constructionCount = count(1) from Construction;
select @houseCount = count(1) from house;

WHILE @count <= @houseCount BEGIN

	UPDATE House SET ConstructionID = CONVERT(INT,RAND() * @constructionCount) WHERe id = @count;;
	SET @count = @count + 1;

END


