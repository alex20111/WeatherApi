
package net.weather.underground.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class StormBased {

    @SerializedName("vertices")
    @Expose
    private List<Vertex> vertices = new ArrayList<Vertex>();
    @SerializedName("Vertex_count")
    @Expose
    private Integer VertexCount;
    @SerializedName("stormInfo")
    @Expose
    private StormInfo stormInfo;

    /**
     * 
     * @return
     *     The vertices
     */
    public List<Vertex> getVertices() {
        return vertices;
    }

    /**
     * 
     * @param vertices
     *     The vertices
     */
    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    /**
     * 
     * @return
     *     The VertexCount
     */
    public Integer getVertexCount() {
        return VertexCount;
    }

    /**
     * 
     * @param VertexCount
     *     The Vertex_count
     */
    public void setVertexCount(Integer VertexCount) {
        this.VertexCount = VertexCount;
    }

    /**
     * 
     * @return
     *     The stormInfo
     */
    public StormInfo getStormInfo() {
        return stormInfo;
    }

    /**
     * 
     * @param stormInfo
     *     The stormInfo
     */
    public void setStormInfo(StormInfo stormInfo) {
        this.stormInfo = stormInfo;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(vertices).append(VertexCount).append(stormInfo).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StormBased) == false) {
            return false;
        }
        StormBased rhs = ((StormBased) other);
        return new EqualsBuilder().append(vertices, rhs.vertices).append(VertexCount, rhs.VertexCount).append(stormInfo, rhs.stormInfo).isEquals();
    }

}
