package com.zxjz.service;

import com.zxjz.dto.excution.AtMarchantFindExcution;
import com.zxjz.dto.in.AtMarchantFindDto;

/**
 * Created by Administrator on 2017/10/23 0023.
 */
public interface AtMarchantFindService {

    public AtMarchantFindExcution getMarchantList(AtMarchantFindDto atMarchantFindDto);

    public AtMarchantFindExcution getMarchantIsLook(AtMarchantFindDto atMarchantFindDto);

    public AtMarchantFindExcution editMarchant(AtMarchantFindDto atMarchantFindDto);

    public AtMarchantFindExcution getMarchantListTimeSearch(AtMarchantFindDto atMarchantFindDto);
}
