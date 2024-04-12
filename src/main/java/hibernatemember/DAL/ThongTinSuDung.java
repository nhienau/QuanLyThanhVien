package hibernatemember.DAL;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "thongtinsd")
public class ThongTinSuDung {

    @Id
    private int MaTT;

//    @Column
//    private int MaTV;
//    @Column
//    private int MaTB;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date TGVao;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date TGMuon;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date TGTra;
    // getThanhVien().getMaTV

    @ManyToOne
    @JoinColumn(name = "MaTV")
    private ThanhVien thanhVien;

    // getThietBi().getMaTB
    @ManyToOne
    @JoinColumn(name = "MaTB")
    private ThietBi thietBi;

    public ThongTinSuDung() {
    }

//    public ThongTinSuDung(int MaTT, int MaTV, int MaTB, Date TGVao, Date TGMuon, Date TGTra) {
//        this.MaTT = MaTT;
//        this.MaTV = MaTV;
//        this.MaTB = MaTB;
//        this.TGVao = TGVao;
//        this.TGMuon = (TGMuon != null) ? TGMuon : getZeroTime();
//        this.TGTra = (TGTra != null) ? TGTra : getZeroTime();
//    }
//    private Date getZeroTime() {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        calendar.set(Calendar.MILLISECOND, 0);
//        return calendar.getTime();
//    }
    public ThongTinSuDung(int MaTT, int MaTV, int MaTB ,Date TGVao, Date TGMuon, Date TGTra) {
        this.MaTT = MaTT;
        this.thanhVien.setMaTV(MaTV);
        this.thietBi.setMaTB(MaTB);
        this.TGVao = TGVao;
        this.TGMuon = TGMuon;
        this.TGTra = TGTra;
    }
    
//    public ThongTinSuDung(int MaTT, int MaTV ,Date TGVao, Date TGMuon, Date TGTra) {
//        this.MaTT = MaTT;
//        this.thanhVien.setMaTV(MaTV);
////        this.thietBi.setMaTB(MaTB);
//        this.TGVao = TGVao;
//        this.TGMuon = TGMuon;
//        this.TGTra = TGTra;
//    }

}
