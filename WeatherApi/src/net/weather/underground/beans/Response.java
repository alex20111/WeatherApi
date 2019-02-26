
package net.weather.underground.beans;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Response {

    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("termsofService")
    @Expose
    private String termsofService;
    @SerializedName("features")
    @Expose
    private Features features;

    /**
     * 
     * @return
     *     The version
     */
    public String getVersion() {
        return version;
    }

    /**
     * 
     * @param version
     *     The version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 
     * @return
     *     The termsofService
     */
    public String getTermsofService() {
        return termsofService;
    }

    /**
     * 
     * @param termsofService
     *     The termsofService
     */
    public void setTermsofService(String termsofService) {
        this.termsofService = termsofService;
    }

    /**
     * 
     * @return
     *     The features
     */
    public Features getFeatures() {
        return features;
    }

    /**
     * 
     * @param features
     *     The features
     */
    public void setFeatures(Features features) {
        this.features = features;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(version).append(termsofService).append(features).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Response) == false) {
            return false;
        }
        Response rhs = ((Response) other);
        return new EqualsBuilder().append(version, rhs.version).append(termsofService, rhs.termsofService).append(features, rhs.features).isEquals();
    }

}
