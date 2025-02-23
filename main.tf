terraform {
  required_providers {
    local = {
      source  = "hashicorp/local"
      version = "~> 2.1"
    }
  }
}

provider "local" {}

# Use Terraform's HTTP data source to download a file
data "http" "sample_file" {
  url = "https://raw.githubusercontent.com/hashicorp/terraform-website/master/README.md"
}

# Write the downloaded content to a local file (sample.txt)
resource "local_file" "downloaded_sample" {
  content  = data.http.sample_file.body
  filename = "${path.module}/sample.txt"
}
