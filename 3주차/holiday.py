"""
Requirements

Python : 3.11.0
종속성 : requriements.txt 참고
"""
from datetime import datetime, timedelta
import requests
import pandas as pd
from bs4 import BeautifulSoup
from datetime import datetime

# secret
from secret.key import *

years = [2023, 2024]
data = []
# 데이터 받아오기


def getHoliday(year: str):
    """
    API 사용을 위해 공공데이터 포털
    -> https://www.data.go.kr/data/15012690/openapi.do
    에서 공휴일 정보 API를 필요로함.

    API KEY를 받아와야함.
    """

    params = {'serviceKey': KEY_DECODING,
              'solYear': f'{year}'}
    resp = requests.get(END_POINT_URL, params=params)
    if resp:
        xml = BeautifulSoup(resp.text, "lxml")
        items = xml.find('items')

        holidays = [datetime.strptime(
            item.find('locdate').text.strip(), '%Y%m%d') for item in items]
        return pd.DataFrame({"holiday_date": holidays})
    else:
        return 0


def get_weekend(year):
    weekday = []
    date = datetime(year, 1, 1)
    while date.year == year:
        if date.weekday() in [5, 6]:
            weekday.append(date.strftime('%Y-%m-%d'))
        date += timedelta(days=1)

    return pd.DataFrame({"holiday_date": weekday})


if __name__ == "__main__":
    df1 = getHoliday(2023)
    df2 = getHoliday(2024)
    df_1 = pd.concat([df1, df2], axis=0)
    df_1.index = list(range(len(df_1)))
    df_1 = df_1.astype(str)

    df1 = get_weekend(2023)
    df2 = get_weekend(2024)
    df_2 = pd.concat([df1, df2], axis=0)
    df_2.index = list(range(len(df_2)))

    df = pd.concat([df_1, df_2]).drop_duplicates().reset_index(drop=True)

    df.to_csv("holiday_2023~2024.csv")
