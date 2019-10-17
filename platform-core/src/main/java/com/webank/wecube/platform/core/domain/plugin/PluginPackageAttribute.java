package com.webank.wecube.platform.core.domain.plugin;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.webank.wecube.platform.core.utils.constant.DataModelDataType;

@Entity
@Table(name = "plugin_package_attributes", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"entity_id", "name"})
})
public class PluginPackageAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "entity_id")
    private PluginPackageEntity pluginPackageEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reference_id")
    private PluginPackageAttribute pluginPackageAttribute;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "data_type")
    private String dataType;


    public PluginPackageAttribute() {
    }

    public PluginPackageAttribute(PluginPackageEntity pluginPackageEntity,
                                  PluginPackageAttribute pluginPackageAttribute,
                                  String name,
                                  String description,
                                  String dataType) {
        this.pluginPackageEntity = pluginPackageEntity;
        this.pluginPackageAttribute = pluginPackageAttribute;
        this.name = name;
        this.description = description;
        this.dataType = DataModelDataType.fromCode(dataType).getCode();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PluginPackageEntity getPluginPackageEntity() {
        return pluginPackageEntity;
    }

    public void setPluginPackageEntity(PluginPackageEntity pluginPackageEntity) {
        this.pluginPackageEntity = pluginPackageEntity;
    }

    public PluginPackageAttribute getPluginPackageAttribute() {
        return pluginPackageAttribute;
    }

    public void setPluginPackageAttribute(PluginPackageAttribute pluginPackageAttribute) {
        this.pluginPackageAttribute = pluginPackageAttribute;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDataType() {
        return dataType.toLowerCase();
    }

    public void setDataType(String dataType) {
        this.dataType = DataModelDataType.fromCode(dataType).getCode();
    }
}