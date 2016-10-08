FROM java:openjdk-7-jdk

# Create folder to hold lib and helpers
RUN mkdir -p /usr/src/algs4/bin
# Copy lib and helpers into container
COPY algs4/algs4.jar /usr/src/algs4/
COPY algs4/bin/* /usr/src/algs4/bin/
RUN echo '# Add ~/algs4/bin to the PATH' >> ~/.bashrc
RUN echo 'export PATH=$PATH:/usr/src/algs4/bin' >> ~/.bashrc

WORKDIR /usr/src/