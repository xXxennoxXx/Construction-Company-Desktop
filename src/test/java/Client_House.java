import java.util.Random;

import static utils.StringUtils.show;

public class Client_House {

    public static void main(String... args){
        int[] ints = {1593
                ,1595
                ,1597
                ,1599
                ,1600
                ,1601
                ,1603
                ,1605
                ,1607
                ,1609
                ,1610
                ,1611
                ,1613
                ,1615
                ,1617
                ,1619
                ,1620
                ,1621
                ,1623
                ,1625
                ,1627
                ,1629
                ,1630
                ,1631
                ,1633
                ,1635
                ,1637
                ,1639
                ,1640
                ,1641
                ,1643
                ,1645
                ,1647
                ,1649
                ,1650
                ,1651
                ,1653
                ,1655
                ,1657
                ,1659
                ,1660
                ,1661
                ,1663
                ,1665
                ,1667
                ,1669
                ,1670
                ,1671
                ,1673
                ,1675
                ,1677
                ,1679
                ,1680
                ,1681
                ,1683
                ,1685
                ,1687
                ,1689
                ,1690
                ,1691
                ,1693
                ,1695
                ,1697
                ,1699
                ,1700
                ,1701
                ,1703
                ,1705
                ,1707
                ,1709
                ,1710
                ,1711
                ,1713
                ,1715
                ,1717
                ,1719
                ,1720
                ,1721
                ,1723
                ,1725
                ,1727
                ,1729
                ,1730
                ,1731
                ,1733
                ,1735
                ,1737
                ,1739
                ,1740
                ,1741
                ,1743
                ,1745
                ,1747
                ,1749
                ,1750
                ,1751
                ,1753
                ,1755
                ,1757
                ,1759
                ,1760
                ,1761
                ,1763
                ,1765
                ,1767
                ,1769
                ,1770
                ,1771
                ,1773
                ,1775
                ,1777
                ,1779
                ,1780
                ,1781
                ,1783
                ,1785
                ,1787
                ,1789
                ,1790
                ,1791
                ,1793
                ,1795
                ,1797
                ,1799
                ,1800
                ,1801
                ,1803
                ,1805
                ,1807
                ,1809
                ,1810
                ,1811
                ,1813
                ,1815
                ,1817
                ,1819
                ,1820
                ,1821
                ,1823
                ,1825
                ,1827
                ,1829
                ,1830
                ,1831
                ,1833
                ,1835
                ,1837
                ,1839
                ,1840
                ,1841
                ,1843
                ,1845
                ,1847
                ,1849
                ,1850
                ,1851
                ,1853
                ,1855
                ,1857
                ,1859
                ,1860
                ,1861
                ,1863
                ,1865
                ,1867
                ,1869
                ,1870
                ,1871
                ,1873
                ,1875
                ,1877
                ,1879
                ,1880
                ,1881
                ,1883
                ,1885
                ,1887
                ,1889
                ,1890
                ,1891
                ,1893
                ,1895
                ,1897
                ,1899
                ,1900
                ,1901
                ,1903
                ,1905
                ,1907
                ,1909
                ,1910
                ,1911
                ,1913
                ,1915
                ,1917
                ,1919
                ,1920
                ,1921
                ,1923
                ,1925
                ,1927
                ,1929
                ,1930
                ,1931
                ,1933
                ,1935
                ,1937
                ,1939
                ,1940
                ,1941
                ,1943
                ,1945
                ,1947
                ,1949
                ,1950
                ,1951
                ,1953
                ,1955
                ,1957
                ,1959
                ,1960
                ,1961
                ,1963
                ,1965
                ,1967
                ,1969
                ,1970
                ,1971
                ,1973
                ,1975
                ,1977
                ,1979
                ,1980
                ,1981
                ,1983
                ,1985
                ,1987
                ,1989
                ,1990
                ,1991
                ,1993
                ,1995
                ,1997
                ,1999
                ,2000
                ,2001
                ,2003
                ,2005
                ,2007
                ,2009
                ,2010
                ,2011
                ,2013
                ,2015
                ,2017
                ,2019
                ,2020
                ,2021
                ,2023
                ,2025
                ,2027
                ,2029
                ,2030
                ,2031
                ,2033
                ,2035
                ,2037
                ,2039
                ,2040
                ,2041
                ,2043
                ,2045
                ,2047
                ,2049
                ,2050
                ,2051
                ,2053
                ,2055
                ,2057
                ,2059
                ,2060
                ,2061
                ,2063
                ,2065
                ,2067
                ,2069
                ,2070
                ,2071
                ,2073
                ,2075
                ,2077
                ,2079
                ,2080
                ,2081
                ,2083
                ,2085
                ,2087
                ,2089
                ,2090
                ,2091
                ,2093
                ,2095
                ,2097
                ,2099
                ,2100
                ,2101
                ,2103
                ,2105
                ,2107
                ,2109
                ,2110
                ,2111
                ,2113
                ,2115
                ,2117
                ,2119
                ,2120
                ,2121
                ,2123
                ,2125
                ,2127
                ,2129
                ,2130
                ,2131
                ,2133
                ,2135
                ,2137
                ,2139
                ,2140
                ,2141
                ,2143
                ,2145
                ,2147
                ,2149
                ,2150
                ,2151
                ,2153
                ,2155
                ,2157
                ,2159
                ,2160
                ,2161
                ,2163
                ,2165
                ,2167
                ,2169
                ,2170
                ,2171
                ,2173
                ,2175
                ,2177
                ,2179
                ,2180
                ,2181
                ,2183
                ,2185
                ,2187
                ,2189
                ,2190
                ,2191
                ,2193
                ,2195
                ,2197
                ,2199
                ,2200
                ,2201
                ,2203
                ,2205
                ,2207
                ,2209
                ,2210
                ,2211
                ,2213
                ,2215
                ,2217
                ,2219
                ,2220
                ,2221
                ,2223
                ,2225
                ,2227
                ,2229
                ,2230
                ,2231
                ,2233
                ,2235
                ,2237
                ,2239
                ,2240
                ,2241
                ,2243
                ,2245
                ,2247
                ,2249
                ,2250
                ,2251
                ,2253
                ,2255
                ,2257
                ,2259
                ,2260
                ,2261
                ,2263
                ,2265
                ,2267
                ,2269
                ,2270
                ,2271
                ,2273
                ,2275
                ,2277
                ,2279
                ,2280
                ,2281
                ,2283
                ,2285
                ,2287
                ,2289
                ,2290
                ,2291
                ,2293
                ,2295
                ,2297
                ,2299
                ,2300
                ,2301
                ,2303
                ,2305
                ,2307
                ,2309
                ,2310
                ,2311
                ,2313
                ,2315
                ,2317
                ,2319
                ,2320
                ,2321
                ,2323
                ,2325
                ,2327
                ,2329
                ,2330
                ,2331
                ,2333
                ,2335
                ,2337
                ,2339
                ,2340
                ,2341
                ,2343
                ,2345
                ,2347
                ,2349
                ,2350
                ,2351
                ,2353
                ,2355
                ,2357
                ,2359
                ,2360
                ,2361
                ,2363
                ,2365
                ,2367
                ,2369
                ,2370
                ,2371
                ,2373
                ,2375
                ,2377
                ,2379
                ,2380
                ,2381
                ,2383
                ,2385
                ,2387
                ,2389
                ,2390
                ,2391
                ,2393
                ,2395
                ,2397
                ,2399
                ,2400
                ,2401
                ,2403
                ,2405
                ,2407
                ,2409
                ,2410
                ,2411
                ,2413
                ,2415
                ,2417
                ,2419
                ,2420
                ,2421
                ,2423
                ,2425
                };

        Random random = new Random();
        for (int i = 0; i < 4472; i++) {
            show(String.valueOf(ints[Math.abs(random.nextInt())%ints.length]));
        }
        
    }

}