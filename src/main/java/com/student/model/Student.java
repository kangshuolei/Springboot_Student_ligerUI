package com.student.model;

public class Student {
    private Integer sId;

    private String sCode;

    private String sName;

    private String sSex;

    private String sDescription;
    
    private Integer csId;
    
    private String csName;
    
    private Integer rId;
    
    

    public Integer getrId() {
		return rId;
	}

	public void setrId(Integer rId) {
		this.rId = rId;
	}

	public Integer getCsId() {
		return csId;
	}

	public void setCsId(Integer csId) {
		this.csId = csId;
	}

	public String getCsName() {
		return csName;
	}

	public void setCsName(String csName) {
		this.csName = csName;
	}

	public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsCode() {
        return sCode;
    }

    public void setsCode(String sCode) {
        this.sCode = sCode == null ? null : sCode.trim();
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex == null ? null : sSex.trim();
    }

    public String getsDescription() {
        return sDescription;
    }

    public void setsDescription(String sDescription) {
        this.sDescription = sDescription == null ? null : sDescription.trim();
    }

	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sCode=" + sCode + ", sName=" + sName + ", sSex=" + sSex + ", sDescription="
				+ sDescription + ", csId=" + csId + ", csName=" + csName + ", rId=" + rId + "]";
	}
    
    
}