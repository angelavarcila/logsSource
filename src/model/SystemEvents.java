/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author angela
 */
@Entity
@Table(name = "SystemEvents")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SystemEvents.findAll", query = "SELECT s FROM SystemEvents s")
    , @NamedQuery(name = "SystemEvents.findById", query = "SELECT s FROM SystemEvents s WHERE s.id = :id")
    , @NamedQuery(name = "SystemEvents.findByCustomerID", query = "SELECT s FROM SystemEvents s WHERE s.customerID = :customerID")
    , @NamedQuery(name = "SystemEvents.findByReceivedAt", query = "SELECT s FROM SystemEvents s WHERE s.receivedAt = :receivedAt")
    , @NamedQuery(name = "SystemEvents.findByDeviceReportedTime", query = "SELECT s FROM SystemEvents s WHERE s.deviceReportedTime = :deviceReportedTime")
    , @NamedQuery(name = "SystemEvents.findByFacility", query = "SELECT s FROM SystemEvents s WHERE s.facility = :facility")
    , @NamedQuery(name = "SystemEvents.findByPriority", query = "SELECT s FROM SystemEvents s WHERE s.priority = :priority")
    , @NamedQuery(name = "SystemEvents.findByFromHost", query = "SELECT s FROM SystemEvents s WHERE s.fromHost = :fromHost")
    , @NamedQuery(name = "SystemEvents.findByNTSeverity", query = "SELECT s FROM SystemEvents s WHERE s.nTSeverity = :nTSeverity")
    , @NamedQuery(name = "SystemEvents.findByImportance", query = "SELECT s FROM SystemEvents s WHERE s.importance = :importance")
    , @NamedQuery(name = "SystemEvents.findByEventSource", query = "SELECT s FROM SystemEvents s WHERE s.eventSource = :eventSource")
    , @NamedQuery(name = "SystemEvents.findByEventUser", query = "SELECT s FROM SystemEvents s WHERE s.eventUser = :eventUser")
    , @NamedQuery(name = "SystemEvents.findByEventCategory", query = "SELECT s FROM SystemEvents s WHERE s.eventCategory = :eventCategory")
    , @NamedQuery(name = "SystemEvents.findByEventID", query = "SELECT s FROM SystemEvents s WHERE s.eventID = :eventID")
    , @NamedQuery(name = "SystemEvents.findByMaxAvailable", query = "SELECT s FROM SystemEvents s WHERE s.maxAvailable = :maxAvailable")
    , @NamedQuery(name = "SystemEvents.findByCurrUsage", query = "SELECT s FROM SystemEvents s WHERE s.currUsage = :currUsage")
    , @NamedQuery(name = "SystemEvents.findByMinUsage", query = "SELECT s FROM SystemEvents s WHERE s.minUsage = :minUsage")
    , @NamedQuery(name = "SystemEvents.findByMaxUsage", query = "SELECT s FROM SystemEvents s WHERE s.maxUsage = :maxUsage")
    , @NamedQuery(name = "SystemEvents.findByInfoUnitID", query = "SELECT s FROM SystemEvents s WHERE s.infoUnitID = :infoUnitID")
    , @NamedQuery(name = "SystemEvents.findBySysLogTag", query = "SELECT s FROM SystemEvents s WHERE s.sysLogTag = :sysLogTag")
    , @NamedQuery(name = "SystemEvents.findByEventLogType", query = "SELECT s FROM SystemEvents s WHERE s.eventLogType = :eventLogType")
    , @NamedQuery(name = "SystemEvents.findByGenericFileName", query = "SELECT s FROM SystemEvents s WHERE s.genericFileName = :genericFileName")
    , @NamedQuery(name = "SystemEvents.findBySystemID", query = "SELECT s FROM SystemEvents s WHERE s.systemID = :systemID")
    , @NamedQuery(name = "SystemEvents.findByProcessid", query = "SELECT s FROM SystemEvents s WHERE s.processid = :processid")
    , @NamedQuery(name = "SystemEvents.findByChecksum", query = "SELECT s FROM SystemEvents s WHERE s.checksum = :checksum")})
public class SystemEvents implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CustomerID")
    private BigInteger customerID;
    @Column(name = "ReceivedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receivedAt;
    @Column(name = "DeviceReportedTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deviceReportedTime;
    @Column(name = "Facility")
    private Short facility;
    @Column(name = "Priority")
    private Short priority;
    @Column(name = "FromHost")
    private String fromHost;
    @Lob
    @Column(name = "Message")
    private String message;
    @Column(name = "NTSeverity")
    private Integer nTSeverity;
    @Column(name = "Importance")
    private Integer importance;
    @Column(name = "EventSource")
    private String eventSource;
    @Column(name = "EventUser")
    private String eventUser;
    @Column(name = "EventCategory")
    private Integer eventCategory;
    @Column(name = "EventID")
    private Integer eventID;
    @Lob
    @Column(name = "EventBinaryData")
    private String eventBinaryData;
    @Column(name = "MaxAvailable")
    private Integer maxAvailable;
    @Column(name = "CurrUsage")
    private Integer currUsage;
    @Column(name = "MinUsage")
    private Integer minUsage;
    @Column(name = "MaxUsage")
    private Integer maxUsage;
    @Column(name = "InfoUnitID")
    private Integer infoUnitID;
    @Column(name = "SysLogTag")
    private String sysLogTag;
    @Column(name = "EventLogType")
    private String eventLogType;
    @Column(name = "GenericFileName")
    private String genericFileName;
    @Column(name = "SystemID")
    private Integer systemID;
    @Basic(optional = false)
    @Column(name = "processid")
    private String processid;
    @Basic(optional = false)
    @Column(name = "checksum")
    private int checksum;

    public SystemEvents() {
    }

    public SystemEvents(Integer id) {
        this.id = id;
    }

    public SystemEvents(Integer id, String processid, int checksum) {
        this.id = id;
        this.processid = processid;
        this.checksum = checksum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getCustomerID() {
        return customerID;
    }

    public void setCustomerID(BigInteger customerID) {
        this.customerID = customerID;
    }

    public Date getReceivedAt() {
        return receivedAt;
    }

    public void setReceivedAt(Date receivedAt) {
        this.receivedAt = receivedAt;
    }

    public Date getDeviceReportedTime() {
        return deviceReportedTime;
    }

    public void setDeviceReportedTime(Date deviceReportedTime) {
        this.deviceReportedTime = deviceReportedTime;
    }

    public Short getFacility() {
        return facility;
    }

    public void setFacility(Short facility) {
        this.facility = facility;
    }

    public Short getPriority() {
        return priority;
    }

    public void setPriority(Short priority) {
        this.priority = priority;
    }

    public String getFromHost() {
        return fromHost;
    }

    public void setFromHost(String fromHost) {
        this.fromHost = fromHost;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getNTSeverity() {
        return nTSeverity;
    }

    public void setNTSeverity(Integer nTSeverity) {
        this.nTSeverity = nTSeverity;
    }

    public Integer getImportance() {
        return importance;
    }

    public void setImportance(Integer importance) {
        this.importance = importance;
    }

    public String getEventSource() {
        return eventSource;
    }

    public void setEventSource(String eventSource) {
        this.eventSource = eventSource;
    }

    public String getEventUser() {
        return eventUser;
    }

    public void setEventUser(String eventUser) {
        this.eventUser = eventUser;
    }

    public Integer getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(Integer eventCategory) {
        this.eventCategory = eventCategory;
    }

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public String getEventBinaryData() {
        return eventBinaryData;
    }

    public void setEventBinaryData(String eventBinaryData) {
        this.eventBinaryData = eventBinaryData;
    }

    public Integer getMaxAvailable() {
        return maxAvailable;
    }

    public void setMaxAvailable(Integer maxAvailable) {
        this.maxAvailable = maxAvailable;
    }

    public Integer getCurrUsage() {
        return currUsage;
    }

    public void setCurrUsage(Integer currUsage) {
        this.currUsage = currUsage;
    }

    public Integer getMinUsage() {
        return minUsage;
    }

    public void setMinUsage(Integer minUsage) {
        this.minUsage = minUsage;
    }

    public Integer getMaxUsage() {
        return maxUsage;
    }

    public void setMaxUsage(Integer maxUsage) {
        this.maxUsage = maxUsage;
    }

    public Integer getInfoUnitID() {
        return infoUnitID;
    }

    public void setInfoUnitID(Integer infoUnitID) {
        this.infoUnitID = infoUnitID;
    }

    public String getSysLogTag() {
        return sysLogTag;
    }

    public void setSysLogTag(String sysLogTag) {
        this.sysLogTag = sysLogTag;
    }

    public String getEventLogType() {
        return eventLogType;
    }

    public void setEventLogType(String eventLogType) {
        this.eventLogType = eventLogType;
    }

    public String getGenericFileName() {
        return genericFileName;
    }

    public void setGenericFileName(String genericFileName) {
        this.genericFileName = genericFileName;
    }

    public Integer getSystemID() {
        return systemID;
    }

    public void setSystemID(Integer systemID) {
        this.systemID = systemID;
    }

    public String getProcessid() {
        return processid;
    }

    public void setProcessid(String processid) {
        this.processid = processid;
    }

    public int getChecksum() {
        return checksum;
    }

    public void setChecksum(int checksum) {
        this.checksum = checksum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SystemEvents)) {
            return false;
        }
        SystemEvents other = (SystemEvents) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SystemEvents[ id=" + id + " ]";
    }
    
}
