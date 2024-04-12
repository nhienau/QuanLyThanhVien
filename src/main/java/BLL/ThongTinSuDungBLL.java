/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import POJO.DateRange;
import POJO.ThongKeKhuHocTap;
import helper.DateHelper;
import hibernatemember.DAL.ThongTinSuDung;
import hibernatemember.DAL.ThongTinSuDungDAL;
import hibernatemember.DAL.XuLy;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ThongTinSuDungBLL {
    private ThongTinSuDungDAL thongtinsudungDAL;
    
    public ThongTinSuDungBLL()
    {
        thongtinsudungDAL = new ThongTinSuDungDAL();
    }
    
    public boolean newThongTinSuDung(ThongTinSuDung c)
    {
        return thongtinsudungDAL.addThongTinSuDung(c);
    }
    
    public ThongTinSuDung getThongTinSuDung(int MaTT)
    {
        ThongTinSuDung c = thongtinsudungDAL.getThongTinSuDung(MaTT);
        return c;
    }
    
    public ArrayList<ThongTinSuDung> LoadThongTinSuDung() throws ParseException {
        return  thongtinsudungDAL.loadThongTinSuDung();
    }
    
    public int getMaTTAutoIncreasement() throws ParseException {
        ArrayList<ThongTinSuDung> listXuLy = LoadThongTinSuDung();
        int lastIndex = LoadThongTinSuDung().size() - 1;
        return listXuLy.get(lastIndex).getMaTT()+ 1;
    }
    
    public String[] getListMaTB() {
        return thongtinsudungDAL.getListMaTB();
    }
    
    public ArrayList<ThongKeKhuHocTap> thongKeKhuHocTap(DateRange dateRange, String groupBy, String khoa, String nganh) {
        return thongtinsudungDAL.thongKeKhuHocTap(dateRange, groupBy, khoa, nganh);
    }
    
    public Date getMinDate() {
        return thongtinsudungDAL.getMinDate();
    }
    
    public ArrayList<ThongTinSuDung> getStatTTSD(DateRange dateRange, String device, boolean isTGTraNull) {
        return thongtinsudungDAL.getStatTTSD(dateRange, device, isTGTraNull);
    }
    
    public ArrayList<ThongKeKhuHocTap> getStatKhuHocTapUpToHour(DateRange dateRange, String khoa, String nganh) {
        ArrayList<ThongKeKhuHocTap> result = thongtinsudungDAL.getStatKhuHocTapUpToHour(dateRange, khoa, nganh);
        for (ThongKeKhuHocTap i : result) {
            i.setTimeline(DateHelper.subtractHours(i.getTimeline(), 7));
        }
        return result;
    }
}
