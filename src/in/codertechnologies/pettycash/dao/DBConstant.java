package in.codertechnologies.pettycash.dao;


public interface DBConstant 
{
	String DBDatabase="pettycash";
	
	String Product_table="product";
	String DailyTable="daily";
	
	String InsertData="INSERT INTO "+DBDatabase+"."+DailyTable+" VALUES(?,?,?,?,?,?)";
	String DeleteData="DELETE FROM "+DBDatabase+"."+DailyTable+" WHERE did=?";
	String UpdateData="UPDATE "+DBDatabase+"."+DailyTable+" SET productPrice=?,productQuantity=?,productTotal=?  WHERE did=?";
	
	
	//String UpdateData1="UPDATE "+DBDatabase+"."+DailyTable+","+DBDatabase+"."+Product_table+"  set daily.productPrice=?,daily.productQuantity=?,daily.productTotal=?,product.productName=? where daily.did=product.productId;";
	
	
	String FindData="SELECT * FROM pettycash.daily as d,pettycash.product as p WHERE d.pId=p.productId AND d.did=?";
	String GET_ALL_Daily="SELECT * FROM "+DBDatabase+"."+DailyTable;
	
	
		String User_Table="User";
	
	String ADD_USER = "INSERT INTO "+ DBDatabase +"."+ User_Table + " VALUES(?,?)";
	String GET_ALL_USER ="SELECT * FROM "+ DBDatabase +"."+ User_Table +"";
	String UPDATE_USER = "UPDATE "+ DBDatabase +"."+ User_Table + " set userPass=? where userPass=?";

	
	String GET_PRODUCT_NAME_BY_ID="SELECT productName FROM "+DBDatabase+"."+Product_table+" INNER JOIN "+DBDatabase+"."+DailyTable+" ON product.productId = daily.pId WHERE daily.did=?";
	String Get_All_Products="SELECT * FROM " +DBDatabase+"."+Product_table;
	String Get_ProductId_ByName="Select productId from "+DBDatabase+"."+Product_table+" where productName=?";
	
	String INSERT_PRODUCT = "INSERT INTO "+DBDatabase+"."+Product_table+" Values(?,?)";
	String GET_BY_PRODUCT_ID ="SELECT * from "+DBDatabase+"."+Product_table+" WHERE productId=?";
	String UPDATE_PRODUCT ="UPDATE "+DBDatabase+"."+Product_table+" SET productName=? WHERE productId=? ";
	String DELETE_PRODUCT="DELETE FROM "+DBDatabase+"."+Product_table+" WHERE productId=?";
	
	
	
	/*day*/
	String ShowAllTotalOfDay ="Select date1,SUM(productTotal) AS Total from "+DBDatabase+"."+DailyTable+" GROUP BY EXTRACT(DAY FROM date1)";//ALL total bill of date
	String ShowAllTotalOfDayWhere ="Select date1,SUM(productTotal) AS Total from "+DBDatabase+"."+DailyTable+" GROUP BY EXTRACT(DAY FROM date1) WHERE month = EXTRACT(MONTH FROM date1)";//ALL total bill of date
	String SearchByDetailParticularDate= "Select * from "+DBDatabase+"."+DailyTable+" where EXTRACT(DAY FROM date1)=?";//particular date info
	

	/*month*/
	

	String ShowAllTotalOfMonth = "Select date1,SUM(productTotal) AS Total from "+DBDatabase+"."+DailyTable+" GROUP BY EXTRACT(MONTH FROM date1)";
	String SearchByDetailParticularMonth = "select date1,sum(productTotal) as Total from "+DBDatabase+"."+DailyTable+" group by date1 Having MONTH(date1)=?";
	
	
	/*year*/

	String ShowAllTotalOfYEAR = "Select date1,SUM(productTotal) AS Total from "+DBDatabase+"."+DailyTable+" GROUP BY EXTRACT(YEAR FROM date1)";
	String SearchByDetailParticularYear = "select date1,sum(productTotal) as Total from "+DBDatabase+"."+DailyTable+" group by MONTH(date1) Having YEAR(date1)=?";
	
	/*Search Engine*/
	String SearchByProduct = "SELECT  d.did,d.date1, p.productName, d.productPrice, d.productQuantity,d.productTotal FROM pettycash.product p, pettycash.daily d WHERE p.productId =d.pId AND p.productName like ?";
	String SearchByDate = "SELECT  d.did,d.date1, p.productName, d.productPrice, d.productQuantity,d.productTotal FROM pettycash.product p, pettycash.daily d WHERE p.productId =d.pId AND d.date1 like ?";
	String SearchByMonth = "SELECT  d.date1,SUM(productTotal) AS Total  FROM pettycash.daily d WHERE d.date1 like ?";
	
	/*Pagination*/
	
	String GET_ALL_DAILY_PAGINATION = "SELECT * FROM "+DBDatabase+"."+DailyTable+" LIMIT ? OFFSET ?";

}