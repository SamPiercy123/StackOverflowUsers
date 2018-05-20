package com.example.sampiercy.stackoverflowusers

import com.example.sampiercy.stackoverflowusers.api.StackOverflowApiService
import com.example.sampiercy.stackoverflowusers.data.model.UsersResponse
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.reactivex.Single
import javax.inject.Singleton

@Module
class CoreTestModule {

    @Provides
    @Singleton
    fun provideStackOverflowApiService(): StackOverflowApiService {

        return MockStackOverflowApiService()
    }
}

class MockStackOverflowApiService : StackOverflowApiService {
    override fun findUsers(order: String, sortBy: String, numbersOfUsers: Int): Single<UsersResponse> {

        val gsonBuilder = GsonBuilder()
        val gson = gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
        val usersResponse = gson.fromJson<UsersResponse>("{\"items\":[{\"badge_counts\":{\"bronze\":8218" +
                ",\"silver\":7597,\"gold\":632},\"account_id\":11683,\"is_employee\":false,\"last_modified_date\"" +
                ":1526516772,\"last_access_date\":1526742851,\"age\":41,\"reputation_change_year\":29848,\"reputation_chan" +
                "ge_quarter\":9938,\"reputation_change_month\":3836,\"reputation_change_week\":1415,\"reputation_change_da" +
                "y\":200,\"reputation\":1026678,\"creation_date\":1222430705,\"user_type\":\"registered\",\"user_id\":22" +
                "656,\"accept_rate\":86,\"location\":\"Reading, United Kingdom\",\"website_url\":\"http://csharpindepth." +
                "com\",\"link\":\"https://stackoverflow.com/users/22656/jon-skeet\",\"profile_image\":\"https://www.grav" +
                "atar.com/avatar/6d8ebb117e8d83d74ea95fbdd0f87e13?s=128&d=identicon&r=PG\",\"display_name\":\"Jon Skeet\"}" +
                ",{\"badge_counts\":{\"bronze\":3083,\"silver\":2988,\"gold\":276},\"account_id\":52822,\"is_employee\"" +
                ":false,\"last_modified_date\":1526561401,\"last_access_date\":1526739109,\"age\":40,\"" +
                "reputation_change_year\":26338,\"reputation_change_quarter\":9134,\"reputation_change_month\":3406," +
                "\"reputation_change_week\":1211,\"reputation_change_day\":60,\"reputation\":799159,\"creation_date\"" +
                ":1250527322,\"user_type\":\"registered\",\"user_id\":157882,\"accept_rate\":93,\"location\":\"Willemstad," +
                " Cura&#231;ao\",\"website_url\":\"http://balusc.omnifaces.org\",\"link\":\"" +
                "https://stackoverflow.com/users/157882/balusc\",\"profile_image\":\"https://www.gravatar.com/avatar/" +
                "89927e2f4bde24991649b353a37678b9?s=128&d=identicon&r=PG\",\"display_name\":\"BalusC\"},{\"badge_counts\"" +
                ":{\"bronze\":2674,\"silver\":2906,\"gold\":207},\"account_id\":14332,\"is_employee\":false,\"" +
                "last_modified_date\":1526644776,\"last_access_date\":1526743872,\"age\":36,\"reputation_change_year\"" +
                ":23275,\"reputation_change_quarter\":8323,\"reputation_change_month\":3298,\"reputation_change_week\"" +
                ":1198,\"reputation_change_day\":98,\"reputation\":796749,\"creation_date\":1224432467,\"user_type\":\"" +
                "registered\",\"user_id\":29407,\"accept_rate\":86,\"location\":\"Sofia, Bulgaria\",\"website_url\":\"" +
                "http://stackoverflow.com/search?q=user%3a29407&tab=newest\",\"link\":\"https://stackoverflow.com/users" +
                "/29407/darin-dimitrov\",\"profile_image\":\"https://www.gravatar.com/avatar/e3a181e9cdd4757a8b416d93878770c5?s=128&d=identicon&r=PG\"" +
                ",\"display_name\":\"Darin Dimitrov\"},{\"badge_counts\":{\"bronze\":2844,\"silver\":2395,\"gold\":260},\"" +
                "account_id\":4243,\"is_employee\":false,\"last_modified_date\":1526604709,\"last_access_date\":1526747899,\"" +
                "age\":47,\"reputation_change_year\":35719,\"reputation_change_quarter\":12359,\"reputation_change_month\":4737,\"" +
                "reputation_change_week\":1609,\"reputation_change_day\":180,\"reputation\":773565,\"creation_date\":1221344553,\"" +
                "user_type\":\"registered\",\"user_id\":6309,\"accept_rate\":100,\"location\":\"France\",\"website_url\":\"" +
                "http://careers.stackoverflow.com/vonc\",\"link\":\"https://stackoverflow.com/users/6309/vonc\",\"profile_image\"" +
                ":\"https://www.gravatar.com/avatar/7aa22372b695ed2b26052c340f9097eb?s=128&d=identicon&r=PG\",\"display_name\":\"" +
                "VonC\"},{\"badge_counts\":{\"bronze\":1947,\"silver\":1209,\"gold\":102},\"account_id\":9266,\"is_employee\"" +
                ":false,\"last_modified_date\":1526648122,\"last_access_date\":1526749457,\"reputation_change_year\":20894,\"" +
                "reputation_change_quarter\":6954,\"reputation_change_month\":2727,\"reputation_change_week\":983,\"" +
                "reputation_change_day\":47,\"reputation\":753317,\"creation_date\":1221698729,\"user_type\":\"registered\",\"" +
                "user_id\":17034,\"location\":\"Madison, WI\",\"link\":\"https://stackoverflow.com/users/17034/hans-passant\",\"" +
                "profile_image\":\"https://i.stack.imgur.com/Cii6b.png?s=128&g=1\",\"display_name\":\"Hans Passant\"},{\"" +
                "badge_counts\":{\"bronze\":2478,\"silver\":2043,\"gold\":186},\"account_id\":11975,\"is_employee\":true,\"" +
                "last_modified_date\":1526561099,\"last_access_date\":1526684208,\"age\":39,\"reputation_change_year\":27884,\"" +
                "reputation_change_quarter\":9701,\"reputation_change_month\":3475,\"reputation_change_week\":1165,\"" +
                "reputation_change_day\":60,\"reputation\":736268,\"creation_date\":1222667162,\"user_type\":\"moderator\",\"" +
                "user_id\":23354,\"accept_rate\":100,\"location\":\"Forest of Dean, United Kingdom\",\"website_url\":\"" +
                "http://blog.marcgravell.com\",\"link\":\"https://stackoverflow.com/users/23354/marc-gravell\",\"profile_image\"" +
                ":\"https://i.stack.imgur.com/NJcqr.png?s=128&g=1\",\"display_name\":\"Marc Gravell\"},{\"badge_counts\":{\"bronze\"" +
                ":1824,\"silver\":1769,\"gold\":128},\"account_id\":39846,\"is_employee\":false,\"last_modified_date\":1526644776,\"" +
                "last_access_date\":1526749131,\"reputation_change_year\":28373,\"reputation_change_quarter\":10030,\"" +
                "reputation_change_month\":4041,\"reputation_change_week\":1515,\"reputation_change_day\":145,\"reputation\"" +
                ":723068,\"creation_date\":1243786808,\"user_type\":\"registered\",\"user_id\":115145,\"accept_rate\":84,\"" +
                "location\":\"Pennsylvania, United States\",\"website_url\":\"https://commonsware.com\",\"link\":\"" +
                "https://stackoverflow.com/users/115145/commonsware\",\"profile_image\":\"https://i.stack.imgur.com/wDnd8.png?s=128&g=1\"" +
                ",\"display_name\":\"CommonsWare\"},{\"badge_counts\":{\"bronze\":350,\"silver\":247,\"gold\":26},\"account_id\":1165580,\"" +
                "is_employee\":false,\"last_modified_date\":1526658728,\"last_access_date\":1526748766,\"reputation_change_year\":52165,\"" +
                "reputation_change_quarter\":19243,\"reputation_change_month\":7545,\"reputation_change_week\":2890,\"reputation_change_day\"" +
                ":210,\"reputation\":675235,\"creation_date\":1326311637,\"user_type\":\"registered\",\"user_id\":1144035,\"location\":\"" +
                "New York, United States\",\"website_url\":\"http://www.data-miners.com\",\"link\":\"https://stackoverflow.com/users/1144035/gordon-linoff\"" +
                ",\"profile_image\":\"https://www.gravatar.com/avatar/e514b017977ebf742a418cac697d8996?s=128&d=identicon&r=PG\",\"display_name\"" +
                ":\"Gordon Linoff\"},{\"badge_counts\":{\"bronze\":2039,\"silver\":2119,\"gold\":109},\"account_id\":35417,\"is_employee\"" +
                ":false,\"last_modified_date\":1526726090,\"last_access_date\":1526746561,\"age\":45,\"reputation_change_year\"" +
                ":33141,\"reputation_change_quarter\":11263,\"reputation_change_month\":4386,\"reputation_change_week\":1762,\"" +
                "reputation_change_day\":160,\"reputation\":644137,\"creation_date\":1241362437,\"user_type\":\"moderator\",\"" +
                "user_id\":100297,\"location\":\"Cambridge, United Kingdom\",\"website_url\":\"http://www.zopatista.com/\",\"" +
                "link\":\"https://stackoverflow.com/users/100297/martijn-pieters\",\"profile_image\":\"https://www.gravatar.com/" +
                "avatar/24780fb6df85a943c7aea0402c843737?s=128&d=identicon&r=PG\",\"display_name\":\"Martijn Pieters\"},{\"" +
                "badge_counts\":{\"bronze\":1700,\"silver\":1557,\"gold\":131},\"account_id\":15988,\"is_employee\":false,\"" +
                "last_modified_date\":1526572300,\"last_access_date\":1526669405,\"age\":27,\"reputation_change_year\":23613,\"" +
                "reputation_change_quarter\":8114,\"reputation_change_month\":3056,\"reputation_change_week\":1158,\"" +
                "reputation_change_day\":70,\"reputation\":641974,\"creation_date\":1225829805,\"user_type\":\"registered\"" +
                ",\"user_id\":34397,\"accept_rate\":87,\"location\":\"New Jersey\",\"website_url\":\"http://SLaks.net\",\"link\"" +
                ":\"https://stackoverflow.com/users/34397/slaks\",\"profile_image\":\"https://www.gravatar.com/avatar/7deca8ec973c3c0875e9a36e1e3e2c44?s=128&d=identicon&r=PG\"" +
                ",\"display_name\":\"SLaks\"},{\"badge_counts\":{\"bronze\":1192,\"silver\":1090,\"gold\":106},\"account_id\"" +
                ":52616,\"is_employee\":false,\"last_modified_date\":1526704257,\"last_access_date\":1526727055,\"" +
                "reputation_change_year\":33152,\"reputation_change_quarter\":11265,\"reputation_change_month\":4594,\"" +
                "reputation_change_week\":1681,\"reputation_change_day\":71,\"reputation\":623656,\"creation_date\":1250420422,\"" +
                "user_type\":\"registered\",\"user_id\":157247,\"accept_rate\":91,\"location\":\"United Kingdom\",\"website_url\"" +
                ":\"http://www.farsightsoftware.com\",\"link\":\"https://stackoverflow.com/users/157247/t-j-crowder\",\"" +
                "profile_image\":\"https://www.gravatar.com/avatar/ca3e484c121268e4c8302616b2395eb9?s=128&d=identicon&r=PG\",\"" +
                "display_name\":\"T.J. Crowder\"},{\"badge_counts\":{\"bronze\":1134,\"silver\":981,\"gold\":133},\"account_id\"" +
                ":680,\"is_employee\":false,\"last_modified_date\":1526092399,\"last_access_date\":1525432306,\"age\":48,\"" +
                "reputation_change_year\":25691,\"reputation_change_quarter\":9197,\"reputation_change_month\":3553,\"" +
                "reputation_change_week\":1278,\"reputation_change_day\":165,\"reputation\":621574,\"creation_date\":1218356820,\"" +
                "user_type\":\"registered\",\"user_id\":893,\"accept_rate\":84,\"location\":\"Christchurch, New Zealand\",\"" +
                "website_url\":\"http://hewgill.com\",\"link\":\"https://stackoverflow.com/users/893/greg-hewgill\",\"" +
                "profile_image\":\"https://www.gravatar.com/avatar/747ffa5da3538e66840ebc0548b8fd58?s=128&d=identicon&r=PG\",\"" +
                "display_name\":\"Greg Hewgill\"},{\"badge_counts\":{\"bronze\":984,\"silver\":811,\"gold\":66},\"account_id\"" +
                ":10162,\"is_employee\":false,\"last_modified_date\":1526736648,\"last_access_date\":1526749346,\"" +
                "reputation_change_year\":25896,\"reputation_change_quarter\":9393,\"reputation_change_month\":3659,\"" +
                "reputation_change_week\":1423,\"reputation_change_day\":91,\"reputation\":599204,\"creation_date\":1221842906,\"" +
                "user_type\":\"registered\",\"user_id\":19068,\"location\":\"United Kingdom\",\"website_url\":\"\",\"link\":\"" +
                "https://stackoverflow.com/users/19068/quentin\",\"profile_image\":\"" +
                "https://www.gravatar.com/avatar/1d2d3229ed1961d2bd81853242493247?s=128&d=identicon&r=PG\",\"display_name\":\"" +
                "Quentin\"},{\"badge_counts\":{\"bronze\":1605,\"silver\":1171,\"gold\":157},\"account_id\":8291,\"is_employee\"" +
                ":false,\"last_modified_date\":1526453272,\"last_access_date\":1526703329,\"reputation_change_year\":24041,\"" +
                "reputation_change_quarter\":8337,\"reputation_change_month\":3024,\"reputation_change_week\":1108,\"reputation_change_day\":40,\"" +
                "reputation\":590646,\"creation_date\":1221622605,\"user_type\":\"registered\",\"user_id\":14860,\"accept_rate\":100,\"website_url\":\"\",\"" +
                "link\":\"https://stackoverflow.com/users/14860/paxdiablo\",\"profile_image\":\"https://i.stack.imgur.com/vXG1F.png?s=128&g=1\",\"display_name\"" +
                ":\"paxdiablo\"},{\"badge_counts\":{\"bronze\":1120,\"silver\":706,\"gold\":53},\"account_id\":134022,\"is_employee\"" +
                ":false,\"last_modified_date\":1526434716,\"last_access_date\":1526748126,\"age\":47,\"reputation_change_year\":28267,\"" +
                "reputation_change_quarter\":9539,\"reputation_change_month\":3676,\"reputation_change_week\":1400,\"reputation_change_day\"" +
                ":220,\"reputation\":580967,\"creation_date\":1273269250,\"user_type\":\"registered\",\"user_id\"" +
                ":335858,\"accept_rate\":81,\"location\":\"United States\",\"website_url\":\"http://stackoverflow.com/users/335858/dasblinkenlight\"" +
                ",\"link\":\"https://stackoverflow.com/users/335858/dasblinkenlight\",\"profile_image\":\"" +
                "https://www.gravatar.com/avatar/4af3541c00d591e9a518b9c0b3b1190a?s=128&d=identicon&r=PG\",\"" +
                "display_name\":\"dasblinkenlight\"},{\"badge_counts\":{\"bronze\":1251,\"silver\":997,\"gold\":110},\"account_id\"" +
                ":34048,\"is_employee\":false,\"last_modified_date\":1526702758,\"last_access_date\":1526588083,\"age\"" +
                ":62,\"reputation_change_year\":24734,\"reputation_change_quarter\":8543,\"reputation_change_month\":3368,\"" +
                "reputation_change_week\":1170,\"reputation_change_day\":90,\"reputation\":579894,\"creation_date\":1240625354,\"" +
                "user_type\":\"registered\",\"user_id\":95810,\"accept_rate\":80,\"location\":\"Sunnyvale, CA\",\"website_url\"" +
                ":\"http://www.aleax.it\",\"link\":\"https://stackoverflow.com/users/95810/alex-martelli\",\"profile_image\":\"" +
                "https://www.gravatar.com/avatar/e8d5fe90f1fe2148bf130cccd4dc311c?s=128&d=identicon&r=PG\",\"display_name\":\"" +
                "Alex Martelli\"},{\"badge_counts\":{\"bronze\":800,\"silver\":818,\"gold\":151},\"account_id\":3748,\"" +
                "is_employee\":false,\"last_modified_date\":1526637499,\"last_access_date\":1526577554,\"age\":33,\"" +
                "reputation_change_year\":22979,\"reputation_change_quarter\":8129,\"reputation_change_month\":3078,\"" +
                "reputation_change_week\":1090,\"reputation_change_day\":90,\"reputation\":551057,\"creation_date\":1220976258,\"" +
                "user_type\":\"registered\",\"user_id\":5445,\"location\":\"Guatemala\",\"website_url\":\"http://codingspot.com\"" +
                ",\"link\":\"https://stackoverflow.com/users/5445/cms\",\"profile_image\":\"" +
                "https://www.gravatar.com/avatar/932fb89b9d4049cec5cba357bf0ae388?s=128&d=identicon&r=PG\",\"display_name\"" +
                ":\"CMS\"},{\"badge_counts\":{\"bronze\":1305,\"silver\":1285,\"gold\":115},\"account_id\":24377,\"is_employee\"" +
                ":false,\"last_modified_date\":1525360965,\"last_access_date\":1526658839,\"age\":38,\"reputation_change_year\"" +
                ":23534,\"reputation_change_quarter\":8318,\"reputation_change_month\":3230,\"reputation_change_week\":1140,\"" +
                "reputation_change_day\":30,\"reputation\":546322,\"creation_date\":1233672960,\"user_type\":\"registered\",\"" +
                "user_id\":61974,\"location\":\"Denmark\",\"website_url\":\"http://careers.stackoverflow.com/markbyers/\",\"" +
                "link\":\"https://stackoverflow.com/users/61974/mark-byers\",\"profile_image\":\"" +
                "https://www.gravatar.com/avatar/ad240ed5cc406759f0fd72591dc8ca47?s=128&d=identicon&r=PG\",\"display_name\"" +
                ":\"Mark Byers\"},{\"badge_counts\":{\"bronze\":1103,\"silver\":997,\"gold\":90},\"account_id\":10930,\"" +
                "is_employee\":false,\"last_modified_date\":1526630566,\"last_access_date\":1526749574,\"reputation_change_year\"" +
                ":22286,\"reputation_change_quarter\":8303,\"reputation_change_month\":3488,\"reputation_change_week\":1407,\"" +
                "reputation_change_day\":110,\"reputation\":541023,\"creation_date\":1222135580,\"user_type\":\"registered\"" +
                ",\"user_id\":20862,\"accept_rate\":50,\"website_url\":\"\",\"link\":\"" +
                "https://stackoverflow.com/users/20862/ignacio-vazquez-abrams\",\"profile_image\":\"" +
                "https://www.gravatar.com/avatar/2343ae368d3241278581ce6c87f62a25?s=128&d=identicon&r=PG\",\"display_name\":\"" +
                "Ignacio Vazquez-Abrams\"},{\"badge_counts\":{\"bronze\":1205,\"silver\":1043,\"gold\":119},\"account_id\"" +
                ":7633,\"is_employee\":false,\"last_modified_date\":1526543239,\"last_access_date\":1526735628,\"age\":52,\"" +
                "reputation_change_year\":19801,\"reputation_change_quarter\":6871,\"reputation_change_month\":2655,\"" +
                "reputation_change_week\":889,\"reputation_change_day\":60,\"reputation\":539313,\"creation_date\":1221588555,\"" +
                "user_type\":\"registered\",\"user_id\":13302,\"accept_rate\":99,\"location\":\"Bern, Switzerland\",\"" +
                "website_url\":\"\",\"link\":\"https://stackoverflow.com/users/13302/marc-s\",\"profile_image\":\"" +
                "https://www.gravatar.com/avatar/b4779212f57ff2e9549ea90a4499c2d7?s=128&d=identicon&r=PG\",\"display_name\":\"" +
                "marc_s\"}],\"has_more\":true,\"quota_max\":300,\"quota_remaining\":298}",
                UsersResponse::class.java)
        return Single.just(usersResponse)
    }
}



