
package com.sunshine.sunspring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "design_info")
public class DesignInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "design_id")
    private Long design_id;
    
    
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "design_name", nullable = false)
    private String design_name;

    @Column(name = "design_image_url")
    private String design_image_url;

    @Column(name = "status")
    private String status;

    @Column(name = "remarks")
    private String remarks;

    public DesignInfo() {}

    // Getters and Setters
    public Long getDesign_id() {
        return design_id;
    }

    public void setDesign_id(Long design_id) {
        this.design_id = design_id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getDesign_name() {
        return design_name;
    }

    public void setDesign_name(String design_name) {
        this.design_name = design_name;
    }

    public String getDesign_image_url() {
        return design_image_url;
    }

    public void setDesign_image_url(String design_image_url) {
        this.design_image_url = design_image_url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}


/*
package com.sunshine.sunspring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "design_info")
public class DesignInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "design_id")
    private Long designId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "design_name", nullable = false)
    private String designName;

    @Column(name = "design_image_url")
    private String designImageUrl;

    @Column(name = "status")
    private String status;

    @Column(name = "remarks")
    private String remarks;

    public DesignInfo() {}

	public Long getDesignId() {
		return designId;
	}

	public void setDesignId(Long designId) {
		this.designId = designId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getDesignName() {
		return designName;
	}

	public void setDesignName(String designName) {
		this.designName = designName;
	}

	public String getDesignImageUrl() {
		return designImageUrl;
	}

	public void setDesignImageUrl(String designImageUrl) {
		this.designImageUrl = designImageUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

    
}

*/

/*
package com.sunshine.sunspring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "design_info")
public class DesignInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "design_id")
    private Long design_id;

    @Column(name = "order_id", nullable = false)
    private Long order_id;

    @Column(name = "design_name", nullable = false)
    private String design_name;

    @Column(name = "design_image_url")
    private String design_image_url;

    @Column(name = "status")
    private String status;

    @Column(name = "remarks")
    private String remarks;

    public DesignInfo() {}

    // Getters and Setters
    public Long getDesign_id() {
        return design_id;
    }

    public void setDesign_id(Long design_id) {
        this.design_id = design_id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public String getDesign_name() {
        return design_name;
    }

    public void setDesign_name(String design_name) {
        this.design_name = design_name;
    }

    public String getDesign_image_url() {
        return design_image_url;
    }

    public void setDesign_image_url(String design_image_url) {
        this.design_image_url = design_image_url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}



*/
