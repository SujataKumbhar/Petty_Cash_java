package in.codertechnologies.pettycash.dto;

public class SearchEngine 
{
Daily daily;
Product product;
@Override
public String toString() {
	return "SearchEngine [daily=" + daily + ", product=" + product + "]";
}
public Daily getDaily() {
	return daily;
}
public void setDaily(Daily daily) {
	this.daily = daily;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
}
