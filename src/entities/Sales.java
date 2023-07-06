package entities;

public class Sales {
	
	private Integer month;
	private Integer year;
	private String seller;
	private Integer items;
	private Double total;
	
	public Sales(Integer month, Integer year, String seller, Integer items, Double total) {
		this.month = month;
		this.year = year;
		this.seller = seller;
		this.items = items;
		this.total = total;
	}

	public Integer getMonth() {
		return month;
	}

	public Integer getYear() {
		return year;
	}

	public String getSeller() {
		return seller;
	}

	public Integer getItems() {
		return items;
	}

	public Double getTotal() {
		return total;
	}
	
	public void setTotal(Double total) {
		this.total = total;
	}
	
	public Double avaragePrice() {
		return total / items;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((seller == null) ? 0 : seller.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sales other = (Sales) obj;
		if (seller == null) {
			if (other.seller != null)
				return false;
		} else if (!seller.equals(other.seller))
			return false;
		return true;
	}

}