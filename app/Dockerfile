FROM python:3.6
ADD . /test
WORKDIR /test
RUN chmod +x /test/app.py
RUN python /test/app.py \
&& touch text.txt
EXPOSE 3333
#VOLUME /git/test/sorter/:/test/app
CMD python app.py
