package com.keji.pojo.stock;

import com.keji.pojo.baseMessage.Good;
import com.keji.pojo.baseMessage.Repository;
import com.keji.pojo.baseMessage.TProvider;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @version V1.0
 * @Title:
 * @Description:
 * @author: runoob
 * @date:
 */
@Table(name = "t_goods_repsoritory")
public class GoodStockInfo {

    @Column(name = "tgrId")
    private Integer id;

    @Column(name = "iniStoNum")
    private Integer number;

    @Column(name = "gId")
    private Integer gooId;

    @Column(name = "rId")
    private Integer repId;

    @Column(name = "posId")
    private Integer posId;

    @Transient
    private Integer total;

    @Transient
    private Repository repository;

    @Transient
    private Good good;

    @Transient
    private TProvider tProvider;


    public Integer getGooId() {
        return gooId;
    }

    public void setGooId(Integer gooId) {
        this.gooId = gooId;
    }

    public Integer getRepId() {
        return repId;
    }

    public void setRepId(Integer repId) {
        this.repId = repId;
    }

    public Integer getPosId() {
        return posId;
    }

    public void setPosId(Integer posId) {
        this.posId = posId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public TProvider gettProvider() {
        return tProvider;
    }

    public void settProvider(TProvider tProvider) {
        this.tProvider = tProvider;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
