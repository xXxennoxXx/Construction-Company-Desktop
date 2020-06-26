declare @c int,
	@count int

set @c =0
select @count = count(1) from House


while @c <= @count begin

Update house set type = CONVERT(INT,RAND() * 3) where id = @c

set @c = @c +1

end

select * from house where type is null