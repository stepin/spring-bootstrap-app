# DON'T USE, JUST EXAMPLE

FROM openjdk:8
ARG GIT_COMMIT=unknown
ADD . /src
WORKDIR /src
RUN ./gradlew build


FROM openjdk:8
VOLUME /tmp
COPY --from=0  /src/build/libs/api.jar api.jar

ENV JAVA_OPTS=""
ENTRYPOINT java ${JAVA_OPTS} -server -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -Djava.security.egd=file:/dev/./urandom -jar /api.jar
