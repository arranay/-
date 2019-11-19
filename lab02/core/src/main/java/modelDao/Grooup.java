package modelDao;

import java.util.Date;

public class Grooup {
    private int id;
    private String groupName;
    private Date creationDate;
    private String curatorName;

    public Grooup(){}

    public Grooup(int id, String groupName, Date creationDate, String curatorName){
        this.id = id;
        this.groupName = groupName;
        this.creationDate = creationDate;
        this.curatorName = curatorName;
    }
    public Grooup(String groupName, Date creationDate, String curatorName){
        this.groupName = groupName;
        this.creationDate = creationDate;
        this.curatorName = curatorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCuratorName() {
        return curatorName;
    }

    public void setCuratorName(String curatorName) {
        this.curatorName = curatorName;
    }
}
