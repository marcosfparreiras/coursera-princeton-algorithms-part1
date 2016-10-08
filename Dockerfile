FROM java:openjdk-7-jdk

# Create folder to hold lib and helpers
RUN mkdir -p /root/algs4/bin
# Copy lib and helpers into container
COPY algs4/ /root/algs4/
RUN echo '# Add ~/algs4/bin to the PATH' >> ~/.bashrc
RUN echo 'export PATH=$PATH:/root/algs4/bin' >> ~/.bashrc

# Set /usr/src as entrypoint directory
WORKDIR /usr/src/
