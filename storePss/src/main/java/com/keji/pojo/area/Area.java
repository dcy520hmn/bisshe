package com.keji.pojo.area;


import lombok.Data;
import org.omg.PortableInterceptor.INACTIVE;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_area")
@Data
public class Area {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String code;
  private String province;
  private String city;
  private String district;
  private String parent;


}
