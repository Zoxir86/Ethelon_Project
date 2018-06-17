package com.frontend_components;

import com.dto.OpportunityDTO;

import java.util.Calendar;
import java.util.Date;

public class OpportunityCard {

    private int opportunityDatabaseID;      // The opportunity's database ID.
    private OpportunityDTO dto;             // A copy of the DTO that brought the opportunity from the database.
    private String menuItem;                // A code relating the opportunity to a menu category.

    private String location;                // The location where the opportunity takes place, eg. NEO PSYCHIKO, ATTICA.
    private String day;                     // The day of month the opportunity was created as a numerical, eg. 05.
    private String month;                   // The month the opportunity was created as a string, eg. ΑΠΡ.
    private String imagePath;               // The path where the photograph is kept.
    private String category;                // The category of the opportunity.
    private String cardTitle;               // The title (in greek) of the opportunity.
    private String ngo;                     // The organization that posted the opportunity.
    private String description;             // The short description of the opportunity.


    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Constructors ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public OpportunityCard( ) {
        super();
    }

    public OpportunityCard(OpportunityDTO dto) {

        this.opportunityDatabaseID = dto.getDatabaseID();
        this.dto = dto;
        this.menuItem = dto.getPrimarycategory().getDescriptionEnglishLowerCase().substring(0,4);
        this.location = ((dto.getArea().getArea()).concat(", ")).concat(dto.getArea().getPrefecture());

        Date addDate = dto.getAddDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(addDate);
        int cal_month = cal.get(Calendar.MONTH);
        int cal_day = cal.get(Calendar.DAY_OF_MONTH);

        if(cal_day < 10)
        {
            this.day = "0";
            this.day = this.day.concat(Integer.toString(cal_day));
        }
        else
        {
            this.day = Integer.toString(cal_day);
        }

        switch(cal_month) {
            case 0: {
                this.month = "ΙΑΝ";
                break;
            }
            case 1: {
                this.month = "ΦΕΒ";
                break;
            }
            case 2: {
                this.month = "ΜΑΡ";
                break;
            }
            case 3: {
                this.month = "ΑΠΡ";
                break;
            }
            case 4: {
                this.month = "ΜΑΪ";
                break;
            }
            case 5: {
                this.month = "ΙΟΥΝ";
                break;
            }
            case 6: {
                this.month = "ΙΟΥΛ";
                break;
            }
            case 7: {
                this.month = "ΑΥΓ";
                break;
            }
            case 8: {
                this.month = "ΣΕΠ";
                break;
            }
            case 9: {
                this.month = "ΟΚΤ";
                break;
            }
            case 10: {
                this.month = "ΝΟΕ";
                break;
            }
            case 11: {
                this.month = "ΔΕΚ";
                break;
            }
        }

        this.imagePath = dto.getImagePath();
        if(dto.getPrimarycategory() != null) this.category = dto.getPrimarycategory().getDescriptionGreekUpperCase();
        this.cardTitle = dto.getGreekTitle();
        if(dto.getNgo() != null) this.ngo = dto.getNgo().getOrganizationName();
        this.description = dto.getGreekSummary();
    }


    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Methods ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    /********************************************************************************************************************
     Generates HTML code for a card related to the Opportunity.
     *******************************************************************************************************************/

    public String printCard()
    {
        String cardHtml = "\n" +
                "    <div class=\"filterDiv" + this.menuItem + "\">\n" +
                "        <div class=\"column tech\">\n" +
                "            <div class=\"demo-title\">" + this.location + "</div>\n" +
                "            <!-- Post-->\n" +
                "            <div class=\"post-module\">\n" +
                "                <!-- Thumbnail-->\n" +
                "                <div class=\"thumbnail\">\n" +
                "                    <div class=\"date\">\n" +
                "                        <div class=\"day\">" + this.day + "</div>\n" +
                "                        <div class=\"month\">" + this.month + "</div>\n" +
                "                    </div><img src=\"" + this.imagePath + "\"/>\n" +
                "                </div>\n" +
                "                <!-- Post Content-->\n" +
                "                <div class=\"post-content\">\n" +
                "                    <div class=\"category\">" + this.category + "</div>\n" +
                "                    <h1 class=\"title\">" + this.cardTitle + "</h1>\n" +
                "                    <h2 class=\"sub_title\">" + this.ngo + "</h2>\n" +
                "                    <p class=\"description\">" + this.description + "</p>\n" +
                "                    <div class=\"post-meta\" align=\"right\"><span class=\"timestamp\">\n" +
                "                    <i class=\"fa fa-id-card-o\"></i><a href=\"#\"> &#928;&#949;&#961;&#953;&#963;&#963;&#972;&#964;&#949;&#961;&#945;...</a></span></div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>";

        return cardHtml;
    }


    /********************************************************************************************************************
     Generates HTML code for a card related to an Opportunity (DEMO USE ONLY, HARDCODED INFORMATION).
     *******************************************************************************************************************/

    public String printDemo()
    {
        String h = "\n" +
                "    <div class=\"filterDiv tech\">\n" +
                "        <div class=\"column tech\">\n" +
                "            <div class=\"demo-title\">&#920;&#917;&#931;&#931;&#913;&#923;&#927;&#925;&#921;&#922;&#919;, &#920;&#917;&#931;&#931;&#913;&#923;&#927;&#925;&#921;&#922;&#919;</div>\n" +
                "            <!-- Post-->\n" +
                "            <div class=\"post-module\">\n" +
                "                <!-- Thumbnail-->\n" +
                "                <div class=\"thumbnail\">\n" +
                "                    <div class=\"date\">\n" +
                "                        <div class=\"day\">01</div>\n" +
                "                        <div class=\"month\">&#924;&#913;&#938;</div>\n" +
                "                    </div><img src=\"http://www.ethelon.org/wp-content/uploads/2018/04/arduino-day.jpg\"/>\n" +
                "                </div>\n" +
                "                <!-- Post Content-->\n" +
                "                <div class=\"post-content\">\n" +
                "                    <div class=\"category\">&#932;&#917;&#935;&#925;&#927;&#923;&#927;&#915;&#921;&#913;</div>\n" +
                "                    <h1 class=\"title\">Arduino Day Thessaloniki 2018</h1>\n" +
                "                    <h2 class=\"sub_title\">SheSharp Greece</h2>\n" +
                "                    <p class=\"description\">H Arduino Day, &#945;&#960;&#959;&#964;&#949;&#955;&#949;&#943; &#956;&#943;&#945; &#949;&#964;&#942;&#963;&#953;&#945; &#960;&#945;&#947;&#954;&#972;&#963;&#956;&#953;&#945; &#951;&#956;&#949;&#961;&#943;&#948;&#945; &#947;&#953;&#945; &#964;&#959;&#957; &#949;&#959;&#961;&#964;&#945;&#963;&#956;&#972; &#964;&#951;&#962; &#960;&#955;&#945;&#964;&#966;&#972;&#961;&#956;&#945;&#962; &#945;&#957;&#959;&#953;&#967;&#964;&#959;&#973; &#955;&#959;&#947;&#953;&#963;&#956;&#953;&#954;&#959;&#973; &#954;&#945;&#953; &#965;&#955;&#953;&#963;&#956;&#953;&#954;&#959;&#973; Arduino! &#919; &#948;&#953;&#959;&#961;&#947;&#940;&#957;&#969;&#963;&#951; &#960;&#961;&#945;&#947;&#956;&#945;&#964;&#959;&#960;&#959;&#953;&#949;&#943;&#964;&#945;&#953; &#947;&#953;&#945; 3&#951; &#967;&#961;&#959;&#957;&#953;&#940; &#963;&#964;&#951;&#957; &#920;&#949;&#963;&#963;&#945;&#955;&#959;&#957;&#943;&#954;&#951; &#945;&#960;&#972; &#964;&#951;&#957; SheSharp Greece. &#919; Ethelon &#952;&#945; &#948;&#974;&#963;&#949;&#953; &#964;&#959; &#960;&#945;&#961;&#972;&#957; &#963;&#964;&#951;&#957; &#949;&#954;&#948;&#942;&#955;&#969;&#963;&#951; &#945;&#965;&#964;&#942; &#956;&#949; &#964;&#959;&#965;&#962; &#949;&#952;&#949;&#955;&#959;&#957;&#964;&#941;&#962; &#964;&#951;&#962; &#954;&#945;&#953; &#963;&#949; &#954;&#945;&#955;&#949;&#943; &#957;&#945; &#960;&#940;&#961;&#949;&#953;&#962; &#956;&#941;&#961;&#959;&#962;!</p>\n" +
                "                    <div class=\"post-meta\" align=\"right\"><span class=\"timestamp\">\n" +
                "        <i class=\"fa fa-id-card-o\"></i><a href=\"#\"> &#928;&#949;&#961;&#953;&#963;&#963;&#972;&#964;&#949;&#961;&#945;...</a></span></div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>";

        return h;
    }

} // End of OpportunityCard class.
