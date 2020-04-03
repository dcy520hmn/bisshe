package com.keji.pojo.repository;

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
public class GoodRepositoryInfo {
    @Transient
    private Repository repository;

    @Transient
    private Good good;

    @Transient
    private TProvider tProvider;

    @Column(name = "iniStoNum")
    private Integer number;

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
