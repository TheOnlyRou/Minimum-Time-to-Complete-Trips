///You are given an array time where time[i] denotes the time taken by the ith bus to complete one trip.
//
//Each bus can make multiple trips successively; that is, the next trip can start immediately after completing the current trip. Also, each bus operates independently; that is, the trips of one bus do not influence the trips of any other bus.
//
//You are also given an integer totalTrips, which denotes the number of trips all buses should make in total. Return the minimum time required for all buses to complete at least totalTrips trips.
//
//
//
//Example 1:
//
//Input: time = [1,2,3], totalTrips = 5
//Output: 3
//Explanation:
//- At time t = 1, the number of trips completed by each bus are [1,0,0].
//  The total number of trips completed is 1 + 0 + 0 = 1.
//- At time t = 2, the number of trips completed by each bus are [2,1,0].
//  The total number of trips completed is 2 + 1 + 0 = 3.
//- At time t = 3, the number of trips completed by each bus are [3,1,1].
//  The total number of trips completed is 3 + 1 + 1 = 5.
//So the minimum time needed for all buses to complete at least 5 trips is 3.
//Example 2:
//
//Input: time = [2], totalTrips = 1
//Output: 2
//Explanation:
//There is only one bus, and it will complete its first trip at t = 2.
//So the minimum time needed to complete 1 trip is 2.

import java.util.Arrays;
import java.util.List;

public class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int timeTick = 0;
        int tripCount = 0;

        while (tripCount < totalTrips) {
            timeTick++;
            int finalTimeTick = timeTick;
            List<Integer> possible = Arrays.stream(time).boxed().toList().stream().filter(x -> finalTimeTick % x == 0).toList();
            for (int bus : possible) {
                tripCount++;
            }
        }
        return timeTick;
    }

    public long minimumTime2(int[] time, int totalTrips) {
        int n = time.length;
        int minTime = Arrays.stream(time).min().orElse(0);
        long left = minTime * (long) totalTrips / n;
        long right = left + minTime;

        while (left < right) {
            long mid = (left + right) / 2;
            long trips = 0;
            for (int t : time) {
                trips += mid / t;
            }
            if (trips < totalTrips) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }



    public static void main(String[] args) {
        System.out.println(new Solution().minimumTime(new int[]{1, 2, 3}, 5));
        System.out.println(new Solution().minimumTime(new int[]{2}, 1));
        System.out.println(new Solution().minimumTime2(new int[]{35526, 68271, 53295, 85312, 98439, 20401, 12567, 75537, 13042,
                3015, 17945, 51706, 8379, 9020, 68149, 90591, 69251, 9417, 78418, 35804, 36630, 93100, 14223, 27099, 65124, 38701, 93629,
                82300, 78404, 72046, 35760, 11057, 60001, 55960, 96428, 49527, 87398, 89804, 45956, 46031, 48904, 35592, 66810, 2777,
                75831, 753, 82438, 19950, 57812, 24402, 51134, 20588, 25909, 80046, 36073, 71308, 94062, 89630, 18090, 93549, 23207,
                66416, 54285, 76663, 66441, 79464, 67201, 93574, 61759, 54469, 42206, 15010, 17893, 61618, 27951, 90361, 86666, 82842,
                43701, 21837, 56027, 53768, 53220, 56636, 73170, 13353, 22393, 44370, 46178, 39523, 86692, 60228, 37866, 38409, 844,
                36175, 62823, 40866, 71862, 19182, 73662, 11399, 26141, 57640, 19902, 40962, 25361, 58833, 51163, 35488, 5561, 54750,
                84308, 64353, 64150, 17552, 69778, 13564, 6011, 79167, 56980, 98308, 83980, 45116, 56028, 88225, 1824, 93699, 89442,
                22404, 5868, 18700, 44476, 15869, 1583, 57636, 28371, 6270, 66188, 37726, 76939, 79238, 59320, 89811, 66535, 93128,
                21053, 86603, 90383, 17679, 95629, 80276, 62367, 54714, 81017, 88434, 81240, 91915, 14418, 2251, 50001, 57081, 56030,
                11941, 83308, 14990, 37527, 25793, 96967, 12902, 36597, 38487, 10090, 23757, 18301, 70951, 76172, 38409, 12228, 20382,
                16560, 90106, 43687, 99248, 33738, 48726, 65936, 71531, 66629, 95433, 59822, 230, 13699, 21614, 48847, 3254, 9417, 28867,
                38889, 64031, 57498, 83515, 71619, 95748, 86437, 40468, 40175, 1062, 94502, 96956, 240, 14265, 77888, 59298, 27311, 93953,
                99919, 41606, 52803, 51401, 64132, 55876, 85391, 97101, 56438, 21074, 79997, 56815, 92097, 14090, 85007, 83914, 19222,
                30752, 41580, 81193, 82585, 16509, 86366, 5654, 48942, 22998, 73761, 40595, 73144, 90131, 29770, 40487, 58407, 91217,
                86723, 91291, 76943, 87736, 16745, 21252, 71347, 13605, 51863, 67662, 951, 42887, 34961, 71152, 83517, 14521, 63450,
                49661, 72650, 31854, 38506, 14508, 1837, 99584, 73991, 19604, 174, 78776, 34463, 96369, 16743, 9341, 27944, 65679,
                70077, 33227, 52684, 51832, 91464, 34239, 50175, 48925, 9918, 76944, 22485, 24469, 74612, 90584, 21380, 68789, 65552,
                35330, 58725, 30035, 88445, 76097, 90479, 33509, 21790, 69282, 33720, 32661, 92204, 61463, 69033, 18774, 40028, 67322,
                63697, 85469, 42726, 35207, 13436, 49118, 27075, 41241, 12212, 54741, 31899, 38764, 19239, 45927, 79779, 82559, 69922,
                97988, 64077, 60899, 19250, 33197, 12227, 55129, 6161, 7679, 90383, 21720, 38419, 59921, 40394, 22248, 84651, 9919,
                14769, 50547, 35590, 22054, 98547, 92300, 50533, 24494, 6357, 74340, 16444, 36562, 25519, 70299, 91085, 58473, 48549,
                7314, 49789, 50854, 94732, 16473, 22298, 94573, 1177, 16647, 10489, 40756, 11864, 52532, 78056, 72466, 45909, 83358,
                36728, 61145, 24085, 19232, 2698, 5866, 21763, 19417, 52766, 70604, 75357, 86363, 23548, 59612, 57256, 72080, 90665,
                62130, 17811, 11737, 40209, 76143, 84341, 62105, 9559, 15885, 44428, 65942, 73923, 60174, 94085, 85226, 22423, 11680,
                16007, 72223, 92611, 24143, 56415, 99004, 35300, 63534, 91796, 95364, 39871, 39547, 31533, 9820, 19254, 80757, 67351,
                61252, 27802, 9134, 3264, 6660, 43279, 74234, 27708, 92078, 17050, 92833, 33868, 28116, 35816, 23129, 63684, 21393, 445,
                6655, 50495, 45718, 86882, 71493, 7397, 16595, 77758, 80091, 780, 3783, 16168, 55390, 30565, 34707, 32019, 85772, 90904,
                96641, 85382, 61320, 23459, 6965, 97895, 19435, 36616, 9787, 54886, 90036, 92125, 34729, 38960, 66245, 58496, 96129,
                46772, 73733, 65067, 53184, 66181, 58382, 3922, 5387, 65890, 77429, 38183, 84541, 27072, 90736, 94570, 99936, 73272,
                60375, 10952, 9332, 97636, 39694, 13399, 51220, 5018, 36268, 85523, 34753, 53991, 56651, 17209, 7006, 45423, 49624, 9709,
                18987, 4592, 30361, 88433, 48024, 29942, 91592, 8239, 28732, 35824, 4946, 65484, 16979, 33142, 75656, 3209, 22468, 85755,
                39194, 87907, 72594, 43707, 36876, 81362, 15459, 68075, 19741, 18928, 44027, 63719, 21262, 75445, 30250, 51196, 6219,
                34048, 23502, 60665, 1631, 62306, 23264, 67398, 49274, 84972, 16739, 94834, 23334, 82672, 92166, 31032,
                78520, 93931, 28044, 61781, 76557, 33376, 46480, 26749, 22509, 64281, 54589, 50426, 44636, 45225, 99895,
                71585, 17673, 13409, 95493, 90636, 86268, 16980, 7514, 39203, 9907, 27569, 14822, 61552, 41838, 74638,
                87542, 72644, 13042, 1869, 96037, 96075, 126, 74862, 40225, 59462, 42920, 58159, 34863, 72917, 85179,
                48285, 19993, 84466, 7840, 5972, 54264, 43475, 92314, 4800, 19150, 69554, 56691, 19948, 27419, 59213,
                66373, 44592, 46195, 82009, 78601, 17154, 27595, 95329, 36216, 91618, 71112, 10493, 57289, 30769, 54429,
                1855, 13489, 74406, 57880, 3088, 92345, 10824, 87602, 94317, 95410, 79507, 89423, 60715, 37526, 53564,
                98388, 48032, 35013, 60838, 99317, 30389, 69656, 32224, 70212, 53067, 31487, 77619, 32138, 56939, 25282,
                66232, 54525, 51762, 86251, 15422, 96128, 59093, 39155, 91664, 95086, 64328, 58154, 16901, 57839, 36992,
                59934, 61257, 5557, 15425, 57045, 12889, 69846, 29139, 61557, 83756, 32458, 90919, 52963, 14359, 49874,
                80682, 84655, 65452, 55068, 43914, 76328, 45679, 35127, 72774, 62715, 91798, 29872, 81354, 80582, 96103,
                28903, 50678, 9125, 45643, 11868, 9791, 46321, 41872, 7001, 92742, 89046, 77778, 58288, 57737, 28006,
                38887, 4145, 30995, 23181, 22663, 76976, 12037, 94311, 69665, 47087, 243, 85775, 33414, 14113, 25750,
                68464, 27502, 33912, 49055, 86698, 68094, 7608, 70775, 62943, 42776, 34704, 11471, 4417, 99359, 60717,
                71140, 87687, 24846, 22480, 56390, 47598, 28920, 1425, 78664, 65311, 25188, 69310, 46708, 56404, 79811,
                22070, 75607, 32708, 1979, 67357, 81800, 28625, 58021, 29588, 49578, 16281, 18081, 74281, 57898, 39302,
                18506, 70543, 41031, 35986, 1699, 96223, 41042, 13283, 50709, 61933, 91181, 46030, 61266, 66703, 82807,
                89387, 67547, 6497, 55088, 61583, 42425, 91409, 85463, 8301, 78781, 80870, 98576, 55880, 33799, 9806,
                31789, 1220, 49041, 40852, 98197, 88459, 80809, 30683, 45742, 53320, 25920, 65231, 56346, 207, 17794,
                82843, 50215, 57, 47903, 10075, 62437, 2278, 98786, 98119, 45948, 30820, 29230, 1929, 76287, 79090,
                85711, 72527, 92053, 26601, 48647, 76929, 14214, 44902, 76505, 40038, 64918, 60383, 35546, 2544, 40358,
                86056, 60688, 18499, 88770, 22849, 63307, 51149, 60424, 47592, 43259, 26180, 16534, 49804, 23756, 9616,
                13388, 64930, 99325, 39424, 70127, 92799, 91793, 28812, 71828, 14453, 91106, 666, 62810, 11290, 9647,
                22966, 16230, 35343, 84054, 34513, 2255, 89433, 26782, 46009, 53791, 44813, 68657, 49581, 41018, 86354,
                2203, 96565, 76773, 2292, 20466, 91806, 21150, 4547, 34076, 35288, 17350, 37117, 89318, 5010, 41980,
                98619, 34277, 56047, 96091, 14986, 47946, 557, 12310, 45083, 33215, 41672, 76247, 22120, 98394, 52505,
                32913, 13669, 79991, 50390, 84603, 96700, 45380, 83969, 62960, 922, 77322, 89247, 22082, 77155, 58180,
                85090, 34045, 78015, 83134, 65175, 12575, 29973, 33374, 66596, 9773, 3090, 5978, 51347, 10092, 21711,
                12959, 59636, 66040, 79673, 11149, 3982, 70175, 26604, 19115, 27400, 34364, 82326, 23104, 1413, 72067,
                46839, 39644, 24885, 60701, 72571, 46163, 83030, 62798, 48657, 10336, 45398, 31463, 35149, 93705, 89614,
                55496, 94724, 47644, 67168, 252, 67317, 90167, 73396, 79355, 42813, 69604, 60195, 31448, 38177, 8685,
                3453, 27967, 34365, 20916, 31161, 32697, 13569, 56538, 97312, 43741, 20268, 62417, 8800, 58889, 887,
                59083, 37770, 54497, 3483, 13208, 78264, 63926, 51702, 57788, 62339, 34878, 25061, 9272, 33436, 11559,
                24844, 55273, 15700, 86056, 24847, 59543, 88362, 88930, 99160, 76001, 3727, 24347, 62899, 15058, 36773,
                22921, 46114, 25650, 24349, 54426, 88951, 56929, 34112, 35932, 96915, 20056, 5065, 11710, 85022, 4786,
                58819, 86765, 42917, 16629, 75041, 9382, 15583, 19171, 72488, 45448, 12527, 50008, 93346, 80955, 45643,
                28915, 73390, 67806, 29676, 21950, 45132, 98400, 54683, 46952, 36276, 47913, 48498, 1003, 77209, 65162,
                29328, 77900, 23452, 46557, 11635, 60276, 59815, 55051, 47365, 40098, 9110, 42438, 89515, 29366, 57827,
                77546, 87805, 52271, 13786, 13027, 80350, 11753, 39876, 30041, 90876, 79402, 47918, 8267, 44250, 20405,
                2429, 47678, 66426, 74651, 60939, 19540, 75226, 69460, 30180, 2743, 70832, 70474, 56895, 35632, 7563,
                40387, 84892, 72994, 86326, 76410, 12579, 85154, 21588, 97138, 35456, 10816, 66345, 77797, 68559, 33827,
                77916, 36264, 33517, 73029, 83578, 19096, 40231, 15099, 56610, 75386, 1213, 72113, 89289, 50868, 23025,
                47995, 10864, 37206, 21100, 77996, 15471, 34319, 91648, 20577, 67231, 99970, 74615, 67606, 25690, 35923,
                8601, 25104, 31088, 79805, 51973, 51920, 84434, 80312, 25120, 69047, 95483, 50715, 29121, 89649, 46749,
                15222, 93612, 88422, 86352, 65066, 62750, 34466, 64722, 74346, 74135, 11801, 17645, 3812, 92193, 47185,
                34855, 70969, 43411, 70828, 3418, 30992, 16477, 82597, 55609, 44222, 41623, 7218, 28642, 22624, 12312,
                10349, 65818, 2864, 88496, 75385, 1598, 56445, 37344, 25697, 2769, 68254, 46395, 69019, 20250, 35393,
                16111, 71962, 44468, 34732, 99529, 92395, 1285, 41002, 50225, 97701, 69150, 6999, 14127, 2882, 34898,
                19302, 44052, 8041, 47837, 65291, 432, 46098, 8936, 28920, 67179, 54431, 81597, 56203, 18857, 65644,
                66000, 87428, 47819, 22412, 99383, 69228, 86157, 14117, 95023, 86969, 74639, 58154, 4275, 52890, 5310,
                70266, 52189, 37070, 90901, 25435, 60438, 67789, 21700, 82598, 95286, 97387, 79924, 44033, 5780, 47403,
                72271, 65250, 39131, 22041, 98251, 60309, 57013, 1582, 84467, 1141, 21623, 85870, 21842, 59956, 31760,
                89107, 68510, 15402, 49597, 57244, 51077, 73507, 92790, 33644, 79234, 31355, 91673, 35535, 86931, 62187,
                13454, 66936, 57556, 90153, 7256, 19272, 36508, 16036, 44137, 87064, 47269, 91970, 20794, 3900, 55674,
                49311, 39261, 84557, 75459, 97774, 16230, 91469, 37598, 17275, 62318, 1287, 88218, 69983, 56343, 52444,
                6720, 58269, 36530, 79221, 14821, 35676, 19580, 97810, 13112, 60622, 94837, 44378, 3430, 61281, 81910,
                42891, 51976, 76436, 57016, 11020, 4864, 8852, 31660, 17645, 46208, 82855, 56127, 72673, 46038, 12074,
                80563, 36165, 52039, 74661, 97768, 52559, 49274, 82208, 28035, 37180, 23005, 19487, 57510, 5296, 92608,
                41737, 83942, 8223, 24798, 83768, 25029, 88857, 34888, 52171, 63133, 16939, 95122, 31264, 7006, 56696,
                84238, 60986, 25622, 22973, 83335, 3681, 92009, 97206, 67773, 68873, 50397, 51845, 81226, 34, 39384,
                19872, 14387, 29151, 9105, 86972, 20259, 22695, 99301, 50232, 29296, 9107, 4977, 49045, 9573, 25400,
                3430, 1614, 39028, 51323, 45596, 95033, 96890, 30501, 88688, 66127, 99318, 44462, 92340, 9747, 11523,
                12154, 69783, 91358, 57856, 13847, 34876, 82518, 39401, 33473, 71995, 98328, 14358, 23599, 42472, 37601,
                3994, 46517, 25420, 68254, 15846, 34201, 31710, 26821, 58743, 36653, 43639, 40035, 24876, 87497, 77685,
                53880, 3974, 70156, 56738, 54862, 57692, 24496, 78266, 93074, 85729, 90402, 62515, 42192, 71592, 50427,
                95841, 47190, 56716, 90355, 48926, 37564, 85781, 98003, 17932, 1316, 47175, 13691, 21194, 59404, 17063,
                31943, 57638, 31343, 10416, 32230, 48887, 48681, 57475, 6488, 2456, 43990, 14847, 71078, 90582, 15894,
                14900, 607, 97226, 35692, 18656, 5661, 29793, 86919, 9172, 74191, 71616, 98707, 32106, 3270, 1638, 56606,
                33251, 47674, 96531, 83026, 15337, 7690, 59357, 76286, 3004, 9482, 66018, 21242, 35495, 13893, 49569,
                85876, 55793, 33537, 40872, 44376, 16546, 70122, 32100, 21875, 20678, 99865, 50303, 44668, 44693, 91958,
                32585, 72362, 15100, 80982, 84922, 19799, 6281, 71324, 23553, 84000, 11537, 9987, 11989, 78728, 48801,
                22431, 29136, 55355, 1210, 8810, 62511, 73092, 19364, 33795, 72116, 21347, 20963, 65833, 21516, 60259,
                35150, 89862, 30110, 12255, 49310, 62911, 84699, 50812, 87484, 51140, 33180, 23721, 43102, 87331, 64485,
                38692, 99280, 82267, 46525, 65494, 66608, 8576, 4325, 62705, 1264, 73176, 71662, 60603, 8940, 72042,
                59565, 56845, 60963, 84186, 49349, 93269, 52952, 36143, 53723, 71740, 74724, 231, 22097, 38663, 9335,
                43925, 2581, 62739, 98742, 42033, 79802, 79244, 90414, 16019, 45066, 39148, 60390, 30395, 97585, 2146,
                83533, 33083, 21610, 49350, 52022, 11136, 80338, 37984, 48941, 1418, 15299, 83744, 77547, 23283, 17848,
                15580, 96413, 90652, 55304, 80543, 90444, 39736, 25184, 97581, 83751, 2637, 31870, 36141, 56952, 30820,
                53485, 39300, 86380, 83260, 5938, 8041, 31166, 81747, 90246, 59005, 17518, 37891, 76974, 55195, 12518,
                76752, 26574, 65172, 91410, 65445, 25579, 92653, 6594, 60094, 9417, 12545, 59743, 62055, 98462, 9600,
                29863, 67981, 67879, 46846, 7392, 98745, 70390, 4095, 5956, 36155, 68863, 90195, 95964, 77112, 28063,
                90134, 52560, 93874, 49959, 42027, 9440, 34752, 52771, 19849, 87997, 87379, 63548, 59569, 52334, 62692,
                5080, 40490, 91007, 48117, 37029, 94759, 77285, 39529, 1649, 76416, 5543, 10795, 92415, 34982, 93706,
                21511, 34713, 39388, 93102, 26664, 72093, 91344, 48561, 65561, 15644, 4333, 88512, 69922, 628, 30835, 99378, 48424, 50653, 73012, 1566, 32326, 33500, 19250, 87475, 30050, 19891, 9056, 59796, 34813, 54197, 50608, 20856, 65886, 4488, 76521, 1152, 18755, 61160, 48431, 12204, 97447, 76459, 49690, 97698, 70421, 99048, 44070, 73817, 68521, 62422, 7982, 16182, 16317, 39559, 71648, 86796, 72009, 38687, 7436, 50020, 98498, 45169, 93147, 22197, 43132, 61129, 88097, 71996, 89492, 78939, 63460, 13205, 47621, 59854, 93737, 13692, 54880, 36641, 91097, 34018, 13116, 85272, 16665, 64136, 54215, 86626, 1344, 43285, 25293, 79496, 65273, 54408, 77274, 39154, 3993, 15335, 51165, 22634, 97282, 29729, 83357, 54438, 2147, 70104, 19345, 33103, 2427, 79886, 134, 25065, 88081, 27753, 35797, 65751, 54901, 20082, 15923, 92378, 43940, 52952, 41531, 80001, 94902, 95656, 36848, 67464, 42468, 9211, 80210, 37793, 15925, 42715, 13213, 79743, 17011, 61664, 43421, 33152, 3001, 8827, 46763, 10915, 28257, 4300, 74589, 89336, 31085, 57587, 24351, 73466, 43982, 5703, 22216, 49434, 67920, 81581, 8070, 46878, 53676, 89532, 84353, 49629, 5163, 86758, 67050, 77195, 45882, 4109, 57483, 28697, 55679, 5357, 8867, 10287, 62530, 31985, 46750, 84278, 40659, 87414, 98812, 31866, 61325, 37999, 72313, 59255, 73829, 85009, 94233, 86222, 88822, 39680, 51717, 3151, 66283, 17161, 54518, 7700, 7066, 64517, 6455, 38964, 55271, 75958, 28831, 13335, 78981, 74682, 93311, 137, 50773, 19372, 22942, 66193, 7933, 75421, 13298, 10190, 10491, 28390, 2349, 93218, 11645, 64538, 87658, 15518, 75241, 82168, 89629, 86670, 40543, 50129, 72279, 19581, 5069, 97366, 81016, 38763, 17769, 24571, 45101, 97465, 5993, 38154, 99649, 74567, 14153, 21776, 11101, 36717, 87277, 99884, 45629, 47067, 32780, 48605, 38675, 85488, 16652, 56868, 90644, 96598, 70106, 82602, 33629, 39929, 56605, 87478, 43391, 93309, 22052, 79389, 2886, 11742, 36552, 60021, 54743, 24589, 50454, 53864, 96536, 38350, 69221, 94679, 96750, 26718, 71884, 91060, 12596, 81109, 78873, 92336, 87173, 90842, 23954, 63750, 90190, 55545, 39966, 58230, 94228, 9983, 27601, 73590, 70753, 19505, 94838, 68347, 37238, 94375, 53468, 26863, 57021, 26752, 68456, 45976, 7388, 55056, 13700, 66683, 77694, 18425, 12599, 88877, 6592, 62482, 18514, 82483, 4059, 49734, 36353, 63711, 91839, 29652, 20495, 80155, 57275, 89396, 16259, 97239, 12774, 73692, 41461, 12599, 56618, 4314, 75868, 38425, 59913, 48445, 11992, 54171, 61090, 77076, 22021, 90628, 592, 41149, 59668, 8392, 73326, 70286, 39969, 28559, 90760, 12728, 22485, 38024, 56805, 72248, 62374, 93814, 56603, 36766, 20483, 29108, 69899, 54716, 92157, 8007, 68409, 99130, 83088, 62064, 144, 57140, 91156, 44663, 74510, 28720, 28887, 95520, 33241, 13690, 51013, 66789, 91294, 39465, 95469, 49585, 50342, 16904, 56808, 53684, 18149, 21524, 32434, 7033, 59557, 18526, 95720, 80121, 53717, 65132, 53858, 3129, 64755, 24806, 70014, 94176, 80436, 71800, 30134, 33173, 46264, 26137, 75713, 28208, 10992, 77348, 72817, 40145, 26088, 21285, 73042, 66484, 15626, 21952, 76775, 42444, 6457, 63242, 11260, 54694, 93444, 51599, 80659, 71495, 59436, 91785, 73158, 67306, 76508, 91721, 78035, 54869, 94827, 4616, 66911, 35121, 79145, 3920, 27705, 6077, 5951, 22868, 95675, 31171, 46438, 16183, 90960, 28559, 12650, 89791, 5334, 56919, 44770, 17565, 53393, 11235, 99655, 22951, 59332, 78189, 47541, 50688, 7868, 20470, 66262, 81947, 75386, 26269, 8458, 86601, 31819, 74789, 45359, 59133, 16555, 25175, 97976, 4093, 82424, 17599, 8592, 44129, 47207, 98817, 3993, 81424, 72002, 14499, 99665, 27725, 74553, 30765, 80152, 55584, 93326, 96954, 30835, 15545, 8739, 20963, 79883, 3943, 22904, 53927, 20392, 28568, 36203, 24243, 13634, 30241, 74395, 32809, 96123, 64831, 87880, 65959, 20690, 72019, 1078, 1745, 27088, 88529, 48743, 72766, 9200, 20698, 37956, 32501, 21765, 5456, 57915, 85388, 6353, 48909, 12211, 66969, 35961, 271, 66357, 89455, 91880, 48750, 12829, 709, 61938, 25822, 94229, 28856, 93512, 59539, 98099, 17304, 77838, 44476, 53337, 34408, 13134, 52756, 2460, 82552, 3181, 79185, 14560, 53962, 20638, 91608, 16060, 83763, 80765, 71461, 77105, 1350, 62806, 533, 1827, 91473, 38048, 41104, 59689, 67601, 77280, 90046, 13874, 64463, 22874, 42209, 35901, 52004, 3017, 73522, 37798, 82560, 41431, 70841, 72906, 99966, 74204, 94450, 97093, 55200, 63605, 98097, 28731, 62612, 21753, 98228, 93483, 83959, 47443, 60507, 68952, 41553, 28238, 84748, 87948, 81648, 48497, 29304, 92993, 1250, 62819, 4916, 36340, 6264, 62861, 24981, 72707, 96637, 13477, 94568, 79662, 67125, 13883, 78906, 47303, 6845, 85236, 2548, 36519, 93614, 79204, 50412, 61959, 85700, 4800, 98600, 28456, 25639, 66786, 78043, 41685, 20649, 48024, 61669, 45861, 50920, 81257, 48988, 61927, 75672, 4597, 22160, 52118, 43704, 46602, 39978, 87993, 91268, 59623, 78492, 80452, 73226, 15673, 25000, 91346, 19411, 31593, 41439, 32458, 76626, 83509, 11734, 15172, 6204, 91101, 53806, 56872, 34644, 86140, 15379, 99041, 38954, 9485, 72746, 35802, 52522, 43861, 55246, 71723, 15138, 73953, 49241, 80268, 72534, 51332, 862, 56139, 29038, 95060, 87762, 3537, 36833, 95134, 43234, 21821, 50372, 19963, 14537, 7743, 99988, 19814, 10409, 46316, 94909, 82056, 34814, 76070, 14431, 19808, 9138, 10107, 72747, 76360, 64969, 72420, 57298, 73337, 1092, 50757, 82779, 82283, 81662, 60064, 44324, 97633, 18546, 86655, 13623, 29278, 18145, 77557, 55193, 97046, 16813, 46822, 17640, 24407, 1648, 27760, 46156, 36317, 9572, 33885, 17241, 31190, 72577, 74632, 34306, 13532, 82934, 17653, 90196, 17569, 1195, 94533, 1785, 14079, 53823, 36039, 38293, 10499, 25996, 17919, 17775, 82137, 61091, 87037, 54862, 14250, 86348, 66202, 29160, 6857, 82758, 74672, 31383, 66637, 36939, 4434, 78175, 51977, 94507, 49712, 77798, 20749, 12807, 7605, 27805, 35523, 46808, 93285, 18164, 82679, 94642, 54265, 42967, 14329, 60799, 37518, 89214, 24196, 46991, 2246, 10739, 49335, 63458, 21711, 70470, 37318, 10334, 31199, 20092, 25850, 98167, 93952, 19082, 92091, 94719, 62500, 11090, 64723, 56363, 39439, 64377, 70009, 61914, 94347, 98169, 28996, 32103, 22804, 78934, 939, 92408, 66888, 9870, 38777, 87901, 72488, 87911, 24955, 54019, 52939, 14843, 74475, 30004, 48451, 61505, 56924, 38228, 25740, 86307, 33182, 88115, 42208, 14926, 43483, 96176, 94678, 1372, 69037, 4418, 54696, 12865, 18591, 32249, 61284, 99269, 82537, 53923, 75171, 52963, 82016, 65938, 6070, 74983, 82844, 2031, 13023, 36900, 65176, 15851, 42420, 5611, 34357, 4229, 62968, 90842, 65618, 18943, 72826, 57326, 9398, 55950, 57246, 82142, 69845, 74193, 17392, 39558, 3894, 71351, 17800, 42863, 38226, 49762, 83380, 67348, 98797, 37393, 49419, 99379, 22110, 29993, 18580, 12621, 6540, 60437, 82793, 82963, 70567, 61916, 88170, 99020, 42100, 94015, 71494, 60055, 28177, 42828, 41783, 32945, 7178, 68743, 87574, 71950, 19679, 72667, 8794, 3496, 47204, 44998, 44424, 61927, 12982, 18249, 83032, 31449, 14831, 87554, 60444, 45411, 25603, 79296, 35933, 34591, 48091, 20148, 91927, 39965, 2035, 7913, 66837, 18925, 82814, 77992, 12197, 41227, 18476, 27648, 92569, 11478, 82879, 5618, 3434, 98822, 95399, 84697, 71575, 9661, 97451, 63312, 54273, 70919, 28565, 25086, 39626, 91069, 22646, 88443, 45339, 66406, 54488, 54367, 45993, 87062, 23033, 1536, 7085, 56507, 15017, 84041, 94867, 39256, 81530, 42457, 18235, 61187, 54792, 42708, 25221, 24433, 39207, 51027, 13787, 40006, 2537, 28987, 86268, 7351}, 9765277));
    }

}
